package org.fao.service.dtoExcel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fao.model.ItemEntradas;

public class EntradasExcel {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<ItemEntradas> listaItemEntradas;

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(0);
		cell.setCellValue("Medicamentos");
		cell = row.createCell(1);
		cell.setCellValue("Tipo De Medicamento");
		cell = row.createCell(2);
		cell.setCellValue("Lotes");
		cell = row.createCell(3);
		cell.setCellValue("Armario");
		cell = row.createCell(4);
		cell.setCellValue("Pratileira");
		cell = row.createCell(5);
		cell.setCellValue("Quantidade Entradas");
		cell = row.createCell(6);
		cell.setCellValue("Quantidade Actual");
		cell = row.createCell(7);
		cell.setCellValue("Fornecedores");
		cell = row.createCell(8);
		cell.setCellValue("Utilizador Registrou");
		cell = row.createCell(9);
		cell.setCellValue("Data Entrada");
		cell = row.createCell(10);
		cell.setCellValue("Tipo Entrada");
		cell = row.createCell(11);
		cell.setCellValue("Custo Entrada");
		
	}

	private void writeDataRow() {
		int rouCount =1;
		for (ItemEntradas entradas : listaItemEntradas) {
			
			Row row = sheet.createRow(rouCount);
			Cell cell = row.createCell(0);
			cell.setCellValue(entradas.getProductos().getNome());
			cell =row.createCell(1);
			cell.setCellValue(entradas.getTipo().getDescricao());
			cell =row.createCell(2);
			cell.setCellValue(entradas.getLote());
			cell =row.createCell(3);
			cell.setCellValue(entradas.getArmario());
			cell =row.createCell(4);
			cell.setCellValue(entradas.getPratileira());
			cell =row.createCell(5);
			cell.setCellValue(entradas.getQuantidade());
			cell =row.createCell(6);
			cell.setCellValue(entradas.getQuantidadeActual());
			cell =row.createCell(7);
			cell.setCellValue(entradas.getEntradas().getFornecedores().getNome());
			cell =row.createCell(8);
			cell.setCellValue(entradas.getEntradas().getUtilizador().getName());
			cell =row.createCell(9);
			cell.setCellValue(entradas.getEntradas().getDataEntrada());
			cell =row.createCell(10);
			cell.setCellValue(entradas.getEntradas().getTipoEntrada());
			cell =row.createCell(11);
			cell.setCellValue(converterCustro(entradas.getCustoLotes()));
// TDOS QUE JA VEM , AS DATAS FORNECEDORES, UTILIZADOR, DOACAO OU COMPRA, VALOR
			rouCount ++;
		}
	}   

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRow();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

	
	// validar um método para adcionar uma lista antes de chamar para para preencher o excel..
	public EntradasExcel(List<ItemEntradas> listaEcas) {
		this.listaItemEntradas = listaEcas;
		workbook= new XSSFWorkbook();
		sheet= workbook.createSheet();
	}
	
	// CONVERTER O CUSTO
	public double converterCustro(BigDecimal valor) {
		return valor.doubleValue();	
	}
	

}
