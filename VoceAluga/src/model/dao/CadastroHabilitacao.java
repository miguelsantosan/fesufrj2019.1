package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Habilitacao;

public class CadastroHabilitacao {
	
	public static Habilitacao habilitacaoAtual;
	
	public boolean buscarHabilitacaoPorNumeroDeRegistro(String numeroDeRegistro){
		String query = "SELECT * FROM Habilitacao WHERE numeroDeRegistro = \""+numeroDeRegistro+"\";";

		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			ResultSet rs    = stmt.executeQuery(query);
			
			while((rs.next())){
		       	 habilitacaoAtual = new Habilitacao(rs.getString("numeroDeRegistro"),rs.getString("categoria"),
		       			            rs.getDate("validade").toLocalDate(), rs.getDate("dataDeEmissao").toLocalDate());
			}
			
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroHabilitacao: Método buscarHabilitacaoPorNumeroDeRegistro");
			System.err.println(e.getMessage());
		}
		
		return true;
	}
	

}
