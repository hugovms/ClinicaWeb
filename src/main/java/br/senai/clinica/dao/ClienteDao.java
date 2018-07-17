package br.senai.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.clinica.model.Cliente;

public class ClienteDao {
	
	
	public boolean apagar(int cod) {
		Connection conectar = Conexao.conectar();
		try {
			PreparedStatement comando = conectar.prepareStatement("delete from cliente where cod = ?");
			comando.setInt(1, cod);
			comando.execute();
			comando.close();
			conectar.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean incluir(Cliente objCliente) {
		
		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "insert into cliente(cidade,nome,endereco,telefone,celular,cpf)"
					+ " values(?,?,?,?,?,?)";
			PreparedStatement comandoSQL = conectarClinica.prepareStatement(sql);
			comandoSQL.setString(2, objCliente.getNome());
			comandoSQL.setString(1, objCliente.getCidade());
			comandoSQL.setString(3, objCliente.getEndereco());
			comandoSQL.setString(4, objCliente.getTelefone());
			comandoSQL.setString(5, objCliente.getCelular());
			comandoSQL.setString(6, objCliente.getCpf());
			comandoSQL.execute();
			comandoSQL.close();
			conectarClinica.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizar(Cliente objCliente) {
		try {
			Connection conectar = Conexao.conectar();
			PreparedStatement comando = conectar.prepareStatement(
					"update cliente set "
					+ "nome = ?,"
					+ "cidade = ?,"
					+ "endereco = ?,"
					+ "telefone = ?,"
					+ "celular = ?,"
					+ "cpf = ? "
					+ "where cod = ?");
			comando.setString(1, objCliente.getNome());
			comando.setString(2, objCliente.getCidade());
			comando.setString(3, objCliente.getEndereco());
			comando.setString(4, objCliente.getTelefone());
			comando.setString(5, objCliente.getCelular());
			comando.setString(6, objCliente.getCpf());
			comando.setInt(7, objCliente.getCod());
			comando.execute();
			comando.close();
			conectar.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public Cliente buscar(int cod) {
		if(cod == 0) {
			return new Cliente();
		}
		try {
			Connection conectar = Conexao.conectar();
			
			PreparedStatement consulta = conectar.prepareStatement(
					"select * from cliente where cod = "+cod);
			ResultSet retorno = consulta.executeQuery();
			retorno.next();
			Cliente objCliente = new Cliente(retorno.getInt("COD"));
			objCliente.setNome(retorno.getString("NOME"));
			objCliente.setEndereco(retorno.getString("ENDERECO"));
			objCliente.setCidade(retorno.getString("CIDADE"));
			objCliente.setTelefone(retorno.getString("TELEFONE"));
			objCliente.setCelular(retorno.getString("CELULAR"));
			objCliente.setCpf(retorno.getString("CPF"));
			consulta.close();
			conectar.close();
			return objCliente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Cliente> pesquisar(){
		
		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "select * from cliente";
			PreparedStatement comandoSQL = conectarClinica.prepareStatement(sql);		
			ResultSet retorno = comandoSQL.executeQuery();
			List<Cliente> listaCliente= new ArrayList<Cliente>();
			while (retorno.next()) {
				Cliente objCliente = new Cliente();
				objCliente.setCod(retorno.getInt("COD"));
				objCliente.setNome(retorno.getString("NOME"));
				objCliente.setEndereco(retorno.getString("ENDERECO"));
				objCliente.setCidade(retorno.getString("CIDADE"));
				objCliente.setTelefone(retorno.getString("TELEFONE"));
				objCliente.setCelular(retorno.getString("CELULAR"));
				objCliente.setCpf(retorno.getString("CPF"));
				listaCliente.add(objCliente);
				
			}
			return listaCliente;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	public List<Cliente> pesquisar(String nome){
		
		try {
			Connection conectarClinica = Conexao.conectar();
			String sql = "select * from cliente where nome like '%"+nome+"%'";
			PreparedStatement comandoSQL = conectarClinica.prepareStatement(sql);		
			ResultSet retorno = comandoSQL.executeQuery();
			List<Cliente> listaCliente= new ArrayList<Cliente>();
			while (retorno.next()) {
				Cliente objCliente = new Cliente();
				objCliente.setCod(retorno.getInt("COD"));
				objCliente.setNome(retorno.getString("NOME"));
				objCliente.setEndereco(retorno.getString("ENDERECO"));
				objCliente.setCidade(retorno.getString("CIDADE"));
				objCliente.setTelefone(retorno.getString("TELEFONE"));
				objCliente.setCelular(retorno.getString("CELULAR"));
				objCliente.setCpf(retorno.getString("CPF"));
				listaCliente.add(objCliente);
				
			}
			return listaCliente;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return null;
	}
}
