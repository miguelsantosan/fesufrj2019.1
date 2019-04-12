package model;

public class Gerente extends Funcionario{
	
	Gerente(){
		super();
		this.nivelDeAcesso = 2;
	}
	
	public Gerente(String nome,String CPF){
		super(nome,CPF);
		this.nivelDeAcesso = 2;
	}
	
	public Gerente(String nome,String CPF,String cargo) {
		super(nome,CPF,cargo);
		this.nivelDeAcesso = 2;
	}
	
	public Gerente(String nome,String CPF,String cargo,String login,String senha) {
		super(nome,CPF,cargo,login,senha);
		this.nivelDeAcesso = 2;
	}
	
}
