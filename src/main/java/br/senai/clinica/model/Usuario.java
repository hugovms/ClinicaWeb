package br.senai.clinica.model;

public class Usuario {
	private int cod;
	private String nome;
	private String email;
	private String senha;
	private int crv;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCrv() {
		return crv;
	}

	public void setCrv(int crv) {
		this.crv = crv;
	}

}
