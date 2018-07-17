package br.senai.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.senai.clinica.model.Usuario;

public class UsuarioDao {
	public Usuario logar(String email, String senha) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement consulta = con.prepareStatement(
					"select * from usuario where email = ? and senha = ?");
			consulta.setString(1, email);
			consulta.setString(2, senha);
			ResultSet resultado = consulta.executeQuery();
			resultado.next();
			Usuario usuario = new Usuario();
			usuario.setCod(resultado.getInt("cod"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setCrv(resultado.getInt("crv"));
			consulta.close();
			con.close();
			return usuario;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		
	}

	public boolean incluir(String nome, String email, int crv) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement consulta = con.prepareStatement(
					"insert into usuario (nome,email,senha,crv)"
					+ "values(?,?,?,?)");
			consulta.setString(1, nome);
			consulta.setString(2, email);
			consulta.setString(3, "senai01");
			consulta.setInt(4, crv);
			consulta.execute();
			consulta.close();
			con.close();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
		
	}

	//usuario com a nova senha
	public boolean mudarSenha(Usuario usuario) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement comandoSql
			= con.prepareStatement(
					"update usuario set senha = ? "
					+ "where cod = ?");
			comandoSql.setString(1, usuario.getSenha());
			comandoSql.setInt(2, usuario.getCod());
			comandoSql.execute();
			comandoSql.close();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
