package br.senai.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senai.clinica.model.Animal;

public class AnimalDao {
	
	public boolean apagar(int cod){
		
		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "delete from animal where cod = ?";
			PreparedStatement comandoSQL = conectarClinica.prepareStatement(sql);
			comandoSQL.setInt(1, cod);
			comandoSQL.execute();
			comandoSQL.close();
			conectarClinica.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public Animal buscar(int cod){
		
		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "select * from animal where cod = ?";
			PreparedStatement comandoSQL = conectarClinica.prepareStatement(sql);
			comandoSQL.setInt(1, cod);
			ResultSet retorno = comandoSQL.executeQuery();
			retorno.next();
			Animal objAnimal = new Animal();
			objAnimal.setCod(retorno.getInt("COD"));
			objAnimal.setNome(retorno.getString("NOME"));
			objAnimal.setRaca(retorno.getString("raca"));
			objAnimal.setTipo(retorno.getString("tipo"));
			objAnimal.setIdade(retorno.getInt("idade"));
			objAnimal.setAlergico(retorno.getString("alergico"));
			ClienteDao dao = new ClienteDao();
			objAnimal.setCliente(dao.buscar(
					retorno.getInt("cod_cliente")));
			return objAnimal;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Animal> pesquisar(String filtro){
		
		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "select * from animal "+filtro;
			PreparedStatement comandoSQL = conectarClinica.prepareStatement(sql);		
			ResultSet retorno = comandoSQL.executeQuery();
			List<Animal> listaAnimal= new ArrayList<Animal>();
			while (retorno.next()) {
				Animal objAnimal = new Animal();
				objAnimal.setCod(retorno.getInt("COD"));
				objAnimal.setNome(retorno.getString("NOME"));
				objAnimal.setRaca(retorno.getString("raca"));
				objAnimal.setTipo(retorno.getString("tipo"));
				objAnimal.setIdade(retorno.getInt("idade"));
				objAnimal.setAlergico(retorno.getString("alergico"));
				ClienteDao dao = new ClienteDao();
				objAnimal.setCliente(dao.buscar(
						retorno.getInt("cod_cliente")));
				listaAnimal.add(objAnimal);
				
			}
			return listaAnimal;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editar(Animal objAnimal) {

		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "update animal "
					+ "set nome = ? ,"
					+ "tipo = ? ,"
					+ "raca = ? ,"
					+ "idade = ? ,"
					+ "alergico = ? "
					+ "where "
					+ "cod =? ";
			PreparedStatement comandoSQL = 
					conectarClinica.prepareStatement(sql);
			comandoSQL.setString(1, objAnimal.getNome());
			comandoSQL.setString(2, objAnimal.getTipo());
			comandoSQL.setString(3, objAnimal.getRaca());
			comandoSQL.setInt(4, objAnimal.getIdade());
			comandoSQL.setString(5, objAnimal.getAlergico());
			comandoSQL.setInt(6, objAnimal.getCod());
			comandoSQL.execute();
			comandoSQL.close();
			conectarClinica.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean incluir(Animal objAnimal) {

		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "insert into animal(nome,tipo,raca,idade,alergico,cod_cliente)" + " values(?,?,?,?,?,?)";
			PreparedStatement comandoSQL = conectarClinica.prepareStatement(sql);
			comandoSQL.setString(1, objAnimal.getNome());
			comandoSQL.setString(2, objAnimal.getTipo());
			comandoSQL.setString(3, objAnimal.getRaca());
			comandoSQL.setInt(4, objAnimal.getIdade());
			comandoSQL.setString(5, objAnimal.getAlergico());
			comandoSQL.setInt(6, objAnimal.getCliente().getCod());
			comandoSQL.execute();
			comandoSQL.close();
			conectarClinica.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
