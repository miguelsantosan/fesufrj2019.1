package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import model.Funcionario;
import model.Gerente;

public class CadastroFuncionario {
	private static ArrayList<Funcionario> funcionariosBuscados;
	private static Funcionario funcionarioAtual;
	
	// CODIGO DE TESTE
	public static boolean buscarFuncionarios(Map<String,String> camposFuncionario){
		funcionariosBuscados = new ArrayList<Funcionario>(); 
			
		String query = "SELECT * FROM Funcionarios";
		query = adicionarParametrosQueryDeBusca(query,camposFuncionario);
		Funcionario funcionarioEncontrado;
		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			ResultSet rs    = stmt.executeQuery(query);
			
			while((rs.next())){
				if(rs.getInt("nivelDeAcesso")==2){
					funcionarioEncontrado= new Gerente(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"));
				}
				else{
					funcionarioEncontrado= new Funcionario(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"));
				}	
		       	 
		       	 
		       	funcionariosBuscados.add(funcionarioEncontrado);
			}
			
			if(funcionariosBuscados.size()==0) return false;
			return true;
			
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroFuncionario: método buscarFuncionarios");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public static String adicionarParametrosQueryDeBusca(String query, Map<String,String> campos){
		boolean algumParametroAdicionado = false; // indica se algum parametro ja foi adicionado apos WHERE
		String[] nomeDosCampos = campos.keySet().toArray(new String[campos.size()]);

		
		if(campos.size()!=0){
			query = query+" WHERE";
			
			for(int i=0; i<campos.size(); i++){
					query= query + gerarParametroParaQueryDeBusca(nomeDosCampos[i], campos, algumParametroAdicionado);
					algumParametroAdicionado = true;
				}
		}
		return query;
	}
	
	public static String gerarParametroParaQueryDeBusca(String nomeDoCampo,Map<String,String> campos,boolean algumParametroAdicionado){
		String parametro = " ";
		if(algumParametroAdicionado) parametro = "AND ";
		parametro = parametro + nomeDoCampo+"=\""+campos.get(nomeDoCampo)+"\" ";
		return parametro;
	}
	
	public static ArrayList<Funcionario> getFuncionariosBuscados() {
		return funcionariosBuscados;
	}
	
	public static boolean buscarPorCPF(String CPF) {
		funcionarioAtual = null;
		
		String query = "SELECT * FROM Funcionarios WHERE CPF=\""+CPF+"\";";
		Funcionario funcionarioEncontrado;
		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){ 
				if(rs.getInt("nivelDeAcesso")==2){
					funcionarioEncontrado= new Gerente(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"));
				}
				else{
					funcionarioEncontrado= new Funcionario(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"));
				}
				 
				
				funcionarioAtual = funcionarioEncontrado;
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroFuncionario: método buscarPorCPF");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public static void buscarPorLogin(String login) {
		funcionarioAtual = new Funcionario();
	}
	
	public static Funcionario getFuncionarioAtual() {
		return funcionarioAtual;
	}
	
	public static void setFuncionarioAtual(Funcionario Funcionario) {
		funcionarioAtual = Funcionario;
	}


}
