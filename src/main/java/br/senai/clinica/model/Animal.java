package br.senai.clinica.model;

public class Animal {

	private int cod;
	private String nome;
	private String raca;
	private String tipo;
	private int idade;
	private String alergico;
	private Cliente cliente;

	public Animal() {
		
	}
	
	public Animal(Cliente cliente) {
		this.cliente = cliente;
	}
	
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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getAlergico() {
		return alergico;
	}

	public void setAlergico(String alergico) {
		this.alergico = alergico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
