package model;



public class Funcionario {
	
	private int nivelDeAcesso = 1;
	String nome;
	String CPF;
	String cargo;
	
	//---Construtores---
	public Funcionario(){
		
	}
	
	public Funcionario(String nome,String CPF){
		this.nome = nome;
		this.CPF = CPF;
	}
	
	public Funcionario(String nome,String CPF,String cargo) {
		this.cargo = cargo;
		this.nome = nome;
		this.CPF = CPF;
	}

	
	//---getters---
	public int getNivelDeAcesso() {
		return this.nivelDeAcesso;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCPF() {
		return this.CPF;
	}
	
	public String getCargo() {
		return this.cargo;
	}
}
