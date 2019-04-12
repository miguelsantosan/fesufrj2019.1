package model.server;

import model.Funcionario;
import model.Gerente;

public class ValidadorDeLogin {
	
	static public Funcionario FuncionarioLogado;
	
	//NAO IMPLEMENTADO
	////Código apenas para teste essa classe deve conferir se o usuario e login constam no BD
	//retorna true se consta e armazena em FuncionarioLogado
	public static boolean  validarLogin(String user,String password) {
		if( user.equals(password)){
			FuncionarioLogado = new Funcionario("nomedofuncionario","cpfdofuncionario","Vendedor");
			return true;
		}
		else if(user.equals(password+"1")){
			FuncionarioLogado = new Gerente("nomedofuncionario","cpfdofuncionario","Gerente");
			return true;
		};		
		return false;
		
		
	}
	
	

}
