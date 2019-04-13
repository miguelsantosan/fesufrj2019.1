package model.server;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Funcionario;
import model.Gerente;
import model.server.MySQLConnector;

public class ValidadorDeLogin {
	
	static public Funcionario FuncionarioLogado;
	
	
	public static boolean  validarLogin(String login,String senha) {
		   FuncionarioLogado = new Funcionario();
	        
	        try {
	             Statement stmt  = MySQLConnector.connection.createStatement();
	             ResultSet rs    = stmt.executeQuery("SELECT * FROM Funcionarios  WHERE login = \""+login+"\" AND senha = \""+senha+"\";");
	             
	             //se algum funcionario foi encontrado instancie e retorne
	             if((rs.next())){
	            	 if(rs.getInt("nivelDeAcesso")==1)
	            		 FuncionarioLogado = new Funcionario(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
	            	 else if(rs.getInt("nivelDeAcesso")==2)
	            		 FuncionarioLogado = new Gerente(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
		            
	            	return true;
	             }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        
			return false;
	
		
		
		
	}
	
	

}
