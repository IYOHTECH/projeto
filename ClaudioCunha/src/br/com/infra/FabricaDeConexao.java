package br.com.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	private Connection con;
	
	public Connection getConnection(){
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/claudio_cunha","root","1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}
}
