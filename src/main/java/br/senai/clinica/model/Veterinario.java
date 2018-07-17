package br.senai.clinica.model;

public class Veterinario {
	private int crv;
	private String nome;
	private String cidade;
	private String endereco;
	private String celular;
	private String cpf;
	
	public Veterinario(int crv) {
		super();
		this.crv = crv;
	}

	public int getCrv() {
		return crv;
	}

	public void setCrv(int crv) {
		this.crv = crv;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
