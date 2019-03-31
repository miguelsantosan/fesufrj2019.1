package model.server;

import model.Funcionario;

public class ValidadorDeLogin {
	
	static public Funcionario FuncionarioLogado;
	
	//NAO IMPLEMENTADO
	////Código apenas para teste essa classe deve conferir se o usuario e login constam no BD
	//retorna nivel de acesso se ele constar ou 0 caso contrário
	public static boolean  validarLogin(String user,String password) {
		if( user.equals(password)){
			FuncionarioLogado = new Funcionario("nomedofuncionario","cpfdofuncionario","Vendedor");
			return true;
		}
		
		return false;
		
		
	}
	
	

}
