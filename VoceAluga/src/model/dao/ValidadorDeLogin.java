package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Funcionario;
import model.Gerente;
import model.dao.MySQLConnector;

public class ValidadorDeLogin {
	
	static private Funcionario funcionarioLogado;
	
	public static Funcionario getFuncionarioLogado(){
		return funcionarioLogado;
	}
	
	
	public static boolean  validarLogin(String login,String senha) {
		   funcionarioLogado = new Funcionario();
	        
	        try {
	             Statement stmt  = MySQLConnector.connection.createStatement();
	             ResultSet rs    = stmt.executeQuery("SELECT * FROM Funcionarios  WHERE login = \""+login+"\" AND senha = \""+senha+"\";");
	             
	             //se algum funcionario foi encontrado instancie e retorne
	             if((rs.next())){
	            	 if(rs.getInt("nivelDeAcesso")==1)
	            		 funcionarioLogado = new Funcionario(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
	            	 else if(rs.getInt("nivelDeAcesso")==2)
	            		 funcionarioLogado = new Gerente(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
		            
	            	return true;
	             }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        
			return false;
	
		
		
		
	}
	
	

}
