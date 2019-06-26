package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
					funcionarioEncontrado= new Gerente(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
				}
				else{
					funcionarioEncontrado= new Funcionario(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
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
					funcionarioEncontrado= new Gerente(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
				}
				else{
					funcionarioEncontrado= new Funcionario(rs.getString("nome"),rs.getString("CPF"),rs.getString("cargo"),rs.getString("login"),rs.getString("senha"));
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
	
	public static boolean cadastrarFuncionario(Map<String,String> campos){
		String query = "INSERT INTO Funcionarios";
		query = adicionarParametrosQueryDeInsercao(query,campos);

		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroFuncionario: método cadastrarFuncionario");
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
	
	public static boolean deletarFuncionario(String CPF){
		String query = "DELETE FROM Funcionarios WHERE CPF=\""+CPF+"\";";
		
		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroFuncionario: método deletarFuncionario");
			System.err.println(e.getMessage());

			return false;
		}
	}
	
	public static Funcionario getFuncionarioAtual() {
		return funcionarioAtual;
	}

	public static void setFuncionarioAtual(Funcionario funcionario) {
		funcionarioAtual = funcionario;
	}

	public static boolean alterarFuncionario(TreeMap<String, String> camposFuncionario) {
		buscarPorCPF(camposFuncionario.get("CPF"));
		
		
		String query = "UPDATE Clientes SET ";
		query = adicionarParametrosQueryUpdate(query, camposFuncionario);
		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroFuncionario: método alterarFuncionario");
			System.err.println(e.getMessage());
			return false;
		}
	}

	private static String adicionarParametrosQueryUpdate(String query, TreeMap<String, String> campos) {
		boolean algumParametroAdicionado = false;
		
		
		for(String key : campos.keySet()){
			
			if(key.equals("CPF")&& campos.get(key).equals("")){ //nao permite que CPF vazio seja adicionado
				if(algumParametroAdicionado){
					query = query + ","+key+"=NULL ";
				}
				else{
					query = query +key+"=NULL ";
					algumParametroAdicionado=true;
				}
			}
			else{
				if(algumParametroAdicionado){
					query = query + ","+key+"=\""+campos.get(key)+"\" ";
				}
				else{
					query = query +key+"=\""+campos.get(key)+"\" ";
					algumParametroAdicionado=true;
				}
			}
		}
		query = query + " WHERE ";
		
		if(campos.containsKey("CPF")){
			query = query+"CPF=\""+ campos.get("CPF")+"\";";
		}
		

		return query;
	}
	
	


}
