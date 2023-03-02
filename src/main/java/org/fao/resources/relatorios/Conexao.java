package org.fao.resources.relatorios;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String URL = "jdbc:sqlserver://localhost:1433;databaseName=gestStoque;encrypt=true;trustServerCertificate=true";
    private String USER = "sa";
    private String SENHA = "ECA2022";

    
	private Connection conn;
 
    public Conexao() {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConn() {
        return conn;
    }
}
