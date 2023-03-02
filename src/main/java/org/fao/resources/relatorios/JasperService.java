package org.fao.resources.relatorios;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class JasperService {

	
	
	//@Autowired
	public static Connection conectar() {

		Conexao con = new Conexao();
		return con.getConn();
	}
	
	private Map<String, Object> params=new HashMap<>();
	public void addParams(String key, Object value) {
		this.params.put(key, value);
	}
	
	
	public byte[] exportPDSubF() throws JRException, FileNotFoundException{
		byte[] bytes = null;
		InputStream inputStream = null;
		inputStream = this.getClass().getResourceAsStream("/jasper/recibo.jasper");
		JasperPrint print  = JasperFillManager.fillReport(inputStream, params, conectar());
		bytes = JasperExportManager.exportReportToPdf(print);
		return bytes;
	}
}
