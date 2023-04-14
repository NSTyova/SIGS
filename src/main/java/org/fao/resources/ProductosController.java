package org.fao.resources;

import java.util.List;
import java.util.Optional;

import org.fao.model.Productos;
import org.fao.model.exception.NegocioException;
import org.fao.model.exception.ProductosNaoEncontradoException;
import org.fao.resources.DTO.ProductosDTO;
import org.fao.service.ProductosService;
import org.fao.service.form.ProductoUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductosController {

	@Autowired
	private ProductosService service;

	@GetMapping
	@Cacheable(value="listaProductos") // CACHE DOS DADOS
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Page<ProductosDTO> listar(@RequestParam(required = false) String codigo, @RequestParam int pagina,
			@RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);

		if (codigo == null) {
			Page<Productos> productos = service.listar(paginacao);
			return ProductosDTO.convert(productos);
		} else {
			Page<Productos> productos = service.buscarPorCodigo(paginacao, codigo);
			return ProductosDTO.convert(productos);
		}
	}
	
	@GetMapping(value = "/search")
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public List<ProductosDTO> buscarPorNome(@RequestParam String nome) {
		
			return service.buscarPorNomes(nome);
	} 
	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CacheEvict(value="listaProductos" , allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Productos adicionar(@RequestBody Productos productos) {
		try {
		
			return service.gravar(productos);
		} catch (ProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@PutMapping("/{productosId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@CacheEvict(value="listaProductos" , allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Productos atualizar(@PathVariable Long productosId, @RequestBody Productos productos) {
		try {
			Productos clienteActual = service.buscarOuFalhar(productosId);
			BeanUtils.copyProperties(productos, clienteActual);
			return service.gravar(clienteActual);
		} catch (ProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@CacheEvict(value="listaProductos" , allEntries = true) // LIMPAR O CACHE DEPOIS DE UMA INSERCAO
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Productos alterarQTD(@PathVariable Long id, @RequestBody ProductoUpdate productos) {
		try {
			
			Productos productoActual = service.buscarOuFalhar(id);
			// ESTE CAMPO PEGA A QUANTIDADE DO BANCO E SOMA COM A QUANTIDADE QUE VEM A LISTA
			//productoActual.setQuantidade(productoActual.getQuantidade() + productos.getQtd());
			// ESTA CAMPO PEGA O RESGIRO DO DTO E MANTEM O MESMO DO BANCO
			//productos.setDataRegistro(productoActual.getDataRegistro());
			BeanUtils.copyProperties(productos, productoActual);
			return  service.gravar(productoActual);
		} catch (ProductosNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@GetMapping("/{productosId}")
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Productos buscar(@PathVariable Long productosId) {
		return service.buscarOuFalhar(productosId);
	}
	
	@GetMapping(value = "/buscar")
	@PreAuthorize("hasAnyAuthority('Administrador', 'Gerente')")
	public Optional<Productos> buscarPorCodigo( String codigo) { 
		return service.buscarCodigo(codigo);
	}
	
	

}
