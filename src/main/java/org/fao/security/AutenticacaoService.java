package org.fao.security;

import java.util.Optional;

import org.fao.model.Utilizador;
import org.fao.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
@Service
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private UtilizadorRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Utilizador> usuarioLogado= repository.findByEmail(username);
		
		if(usuarioLogado.get().isEstado() == false){
			throw new UsernameNotFoundException("Utilizador desativo");
			
		}
		
		if(usuarioLogado.isPresent()) {
			System.out.println(" "+ usuarioLogado.toString());
			return usuarioLogado.get();
		}
		throw new UsernameNotFoundException("Dado invalidos");
	}

}
*/