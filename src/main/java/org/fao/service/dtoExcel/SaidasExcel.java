package org.fao.service.dtoExcel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fao.model.ItemEntradas;
import org.fao.model.ItemSaida;

public class SaidasExcel {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<ItemSaida> listaItemSaidas;

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		
		Cell cell = row.createCell(0);
		cell.setCellValue("Medicamentos");
		cell = row.createCell(1);
		cell.setCellValue("Tipo De Medicamento");
		cell = row.createCell(2);
		cell.setCellValue("Armario");
		cell = row.createCell(3);
		cell.setCellValue("Pratileira");
		cell = row.createCell(4);
		cell.setCellValue("Lote");
		cell = row.createCell(5);
		cell.setCellValue("Quantidade");
		cell = row.createCell(6);
		cell.setCellValue("Departamento");
		cell = row.createCell(7);
		cell.setCellValue("Utilizador que Solicitou");
		cell = row.createCell(8);
		cell.setCellValue("Utilizador que Aprovou");
		cell = row.createCell(9);
		cell.setCellValue("Utilizador que Registrou a Saida");
		cell = row.createCell(9);
		cell.setCellValue("Data Saida");
		
	}

	private void writeDataRow() {
		int rouCount =1;
		for (ItemSaida saidas : listaItemSaidas) {
			
			Row row = sheet.createRow(rouCount);
			Cell cell = row.createCell(0);
			cell.setCellValue(saidas.getProductos().getNome());
			cell =row.createCell(1);
			cell.setCellValue(saidas.getTipo().getDescricao());
			cell =row.createCell(2);
			cell.setCellValue(saidas.getArmario());
			cell =row.createCell(3);
			cell.setCellValue(saidas.getPratileira());
			cell =row.createCell(4);
			cell.setCellValue(saidas.getLote());
			cell =row.createCell(5);
			cell.setCellValue(saidas.getQuanditade());
			cell =row.createCell(6);
			cell.setCellValue(saidas.getSaidas().getSolicitacao().getServicos().getNome());
			cell =row.createCell(7);
			cell.setCellValue(saidas.getSaidas().getSolicitacao().getSolicitante().getName());
			cell =row.createCell(8);
			cell.setCellValue(saidas.getSaidas().getSolicitacao().getAprovou().getName());
			cell =row.createCell(9);
			cell.setCellValue(saidas.getSaidas().getUtlizador().getName());
			cell =row.createCell(10);
			cell.setCellValue(saidas.getSaidas().getDataRegistro());
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
	public SaidasExcel(List<ItemSaida> listaSaidas) {
		this.listaItemSaidas = listaSaidas;
		workbook= new XSSFWorkbook();
		sheet= workbook.createSheet();
	}
	
	
	

}
