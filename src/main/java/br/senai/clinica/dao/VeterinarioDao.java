package br.senai.clinica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.senai.clinica.model.Veterinario;

public class VeterinarioDao {
	public boolean inserir(Veterinario veterinario) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement comandoSql =
			con.prepareStatement("insert into "
					+ "veterinario (crv,nome,cidade,endereco,celular,cpf)"
					+ "values(?,?,?,?,?,?)");
			comandoSql.setInt(1, veterinario.getCrv());
			comandoSql.setString(2, veterinario.getNome());
			comandoSql.setString(3, veterinario.getCidade());
			comandoSql.setString(4, veterinario.getEndereco());
			comandoSql.setString(5, veterinario.getCelular());
			comandoSql.setString(6, veterinario.getCpf());
			comandoSql.execute();
			comandoSql.close();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public Veterinario buscar(int crv) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement comandoSql =
			con.prepareStatement(
					"select * from veterinario where crv = ?");
			comandoSql.setInt(1, crv);
			ResultSet resultado = comandoSql.executeQuery();
			
			resultado.next();
			Veterinario v = new Veterinario(resultado.getInt("crv"));
			v.setNome(resultado.getString("nome"));
			
			comandoSql.close();
			con.close();
			return v;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
