package model;



public class Funcionario {
	
	protected int nivelDeAcesso = 1;
	String nome;
	String CPF;
	String cargo;
	String login;
	String senha;
	
	//---Construtores---
	public Funcionario(){
		
	}
	
	public Funcionario(String nome,String CPF){
		this.nome = nome;
		this.CPF = CPF;
	}
	
	public Funcionario(String nome,String CPF,String cargo) {
		this(nome,CPF);
		this.cargo = cargo;
	}
	
	public Funcionario(String nome,String CPF,String cargo,String login,String senha) {
		this(nome,CPF,cargo);
		this.login = login;
		this.senha = senha;	
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
	
	public String getLogin(){
		return this.login;
	}

	public String getCPFFormatado(){
	  	String CPFFormatado = null;
	  try{
		  CPFFormatado = this.CPF.substring(0,3) +"." + this.CPF.substring(3,6)+ "."
				  		+this.CPF.substring(6,9)+ "-" + this.CPF.substring(9,11);	
	  }catch(IndexOutOfBoundsException e){
		  System.err.println("Cliente.getCPFFormatado");
		  System.err.println(e.getMessage());
	  }
	  return CPFFormatado;
  }

	
	
	
}
