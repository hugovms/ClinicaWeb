package br.senai.clinica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
//  public Connection conectar() {	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/dbclinica",
					"root",
					"root");
		} catch (SQLException | ClassNotFoundException  e) {
			e.printStackTrace();
			System.out.println("Problema na conexao");
			return null;
		}
	}
}
