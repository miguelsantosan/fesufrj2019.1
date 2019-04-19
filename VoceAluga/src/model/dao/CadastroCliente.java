package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

import model.Cliente;

public class CadastroCliente {
	private static ArrayList<Cliente> clientesBuscados;
	private static Cliente clienteAtual;
	
	
	public  static void buscarClientes(Cliente cliente){
		clientesBuscados = new ArrayList<Cliente>();
		
		Map<String,String> campos = obterValoresDosCamposDoCliente(cliente); 	
		String query = "SELECT * FROM Clientes";
		query = adicionarParametrosQueryDeBusca(query,campos);
		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			ResultSet rs    = stmt.executeQuery(query);
			
			while((rs.next())){
		       	 clientesBuscados.add(new Cliente(rs.getInt("ID"),rs.getString("nome"),rs.getString("CPF"),rs.getString("passaporte"),rs.getString("email"),rs.getString("telefone"),rs.getString("CEP"),rs.getString("pais"),
 						 rs.getString("estado"),rs.getString("cidade"),rs.getString("bairro"),rs.getString("rua"),rs.getString("numero"),rs.getString("complemento"),rs.getDate("dataDeNascimento").toLocalDate()));
			}
			
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroCliente: método prepararStatementDeCliente");
			System.err.println(e.getMessage());
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
	
	
	public static Map<String,String> obterValoresDosCamposDoCliente(Cliente cliente){
		Map<String, String> campos = new TreeMap<>();
		if(cliente.getNome() != null) campos.put("nome", cliente.getNome());
		if(cliente.getCPF() != null) campos.put("CPF", cliente.getCPF());
		if(cliente.getPassaporte() != null) campos.put("passaporte",cliente.getPassaporte());
		if(cliente.getCEP()!= null) campos.put("CEP", cliente.getCEP());
		if(cliente.getTelefone()!= null) campos.put("telefone", cliente.getTelefone());
		if(cliente.getEmail()!= null) campos.put("email", cliente.getEmail());

		
		return campos;
	}
	
	public static boolean cadastrarCliente(TreeMap<String,String> campos){
		clientesBuscados = new ArrayList<Cliente>();
		
		String query = "INSERT INTO Clientes ";
		query = adicionarParametrosQueryDeInsercao(query,campos);
		
		System.out.println(query);
		
		try {
			Statement stmt  = MySQLConnector.connection.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("model.dao.CadastroCliente: método prepararStatementDeCliente");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public static String adicionarParametrosQueryDeInsercao(String query,TreeMap<String,String> campos){
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
	

	
	public static ArrayList<Cliente> getClientesBuscados() {
		return clientesBuscados;
	}
	
	public static void buscarPorCPF(String CPF) {
		clienteAtual = new Cliente();
	}
	
	public static Cliente getClienteAtual() {
		return clienteAtual;
	}
	
	public static void setClienteAtual(Cliente cliente) {
		clienteAtual = cliente;
	}

}
