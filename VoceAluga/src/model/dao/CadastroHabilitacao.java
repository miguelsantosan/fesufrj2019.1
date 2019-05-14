package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import model.Habilitacao;

public class CadastroHabilitacao {
	
	public static Habilitacao habilitacaoAtual;
	
	public static boolean buscarHabilitacaoPorNumeroDeRegistro(String numeroDeRegistro){
		String query = "SELECT * FROM Habilitacao WHERE numeroDeRegistro = \""+numeroDeRegistro+"\";";

		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			ResultSet rs    = stmt.executeQuery(query);
			
			if((rs.next())){
		       	 habilitacaoAtual = new Habilitacao(rs.getString("numeroDeRegistro"),rs.getString("categoria"),
		       			            rs.getDate("validade").toLocalDate(), rs.getDate("dataDeEmissao").toLocalDate());
		       	return true;
			}
			return false;
			
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroHabilitacao: Método buscarHabilitacaoPorNumeroDeRegistro");
			System.err.println(e.getMessage());
			return false;
		}
		
		
	}
	
	public static boolean cadastrarHabilitacao(Map<String,String> camposHabilitacao){
		
			
			String query = "INSERT INTO Habilitacao ";
			query = adicionarParametrosQueryDeInsercao(query,camposHabilitacao);
			
			if(camposHabilitacao.get("numeroDeRegistro").equals("")){
				return false;
			}

			
			try {
				Statement stmt  = MySQLConnector.connection.createStatement();
				stmt.executeUpdate(query);
				return true;
			} catch (SQLException e) {
				System.err.println("model.dao.CadastroHabilitacao: método cadastrarHabilitacao");
				System.err.println(e.getMessage());
				return false;
			}
		}
	

public static String adicionarParametrosQueryDeInsercao(String query,Map<String,String> campos){
		boolean algumParametroAdicionado = false; // indica se algum parametro ja foi adicionado apos WHERE
		
		query = query+ " (";
		for(String key : campos.keySet()){
			if(!algumParametroAdicionado){
				query= query + key;
				algumParametroAdicionado = true;
			}
			else{
				query = query +","+key;
			}
		}
		query = query +") VALUES ("; 
		algumParametroAdicionado=false;
		
		for(String key: campos.keySet()){
				if(!algumParametroAdicionado){
					query= query + "\""+campos.get(key)+"\"";
					algumParametroAdicionado = true;
				}
				else{
					query = query +","+"\""+campos.get(key)+"\"";
				}
		}
		
		query = query + ");";
		return query;
	}


	public static boolean deletarHabilitacao(String numeroDeRegistro){
		String query = "DELETE FROM Habilitacao WHERE numeroDeRegistro=\""+numeroDeRegistro+"\";";
		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroHabilitacao: método deletarHabilitacao");
			System.err.println(e.getMessage());

			return false;
		}
	}
}
	


