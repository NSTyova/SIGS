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
		
	}

	private void writeDataRow() {
		int rouCount =1;
		for (ItemEntradas entradas : listaItemEntradas) {
			
			Row row = sheet.createRow(rouCount);
			Cell cell = row.createCell(0);
			cell.setCellValue(entradas.getProductos().getNome());
			cell =row.createCell(1);
			cell.setCellValue(entradas.getTipo().getDescricao());

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
	
	
	

}
