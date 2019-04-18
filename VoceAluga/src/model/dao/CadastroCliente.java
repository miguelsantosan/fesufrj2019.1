package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Cliente;

public class CadastroCliente {
	private static ArrayList<Cliente> clientesBuscados;
	private static Cliente clienteAtual;
	
	
	public  static void buscarClientes(Cliente cliente){
		clientesBuscados = new ArrayList<Cliente>();
		
		Map<String,String> campos = obterValoresDosCamposDoCliente(cliente); 	
		String query = "SELECT * FROM Clientes";
		query = adicionarParametrosQuery(query,campos);
		
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
	
	public static String adicionarParametrosQuery(String query, Map<String,String> campos){
		boolean algumParametroAdicionado = false; // indica se algum parametro ja foi adicionado apos WHERE
		String[] nomeDosCampos = campos.keySet().toArray(new String[campos.size()]);

		
		if(campos.size()!=0){
			query = query+" WHERE";
			
			for(int i=0; i<campos.size(); i++){
					query= query + gerarParametroParaQuery(nomeDosCampos[i], campos, algumParametroAdicionado);
					algumParametroAdicionado = true;
				}
		}
		return query;
	}
		
	
		
	public static String gerarParametroParaQuery(String nomeDoCampo,Map<String,String> campos,boolean algumParametroAdicionado){
		String parametro = " ";
		if(algumParametroAdicionado) parametro = "AND ";
		parametro = parametro + nomeDoCampo+"=\""+campos.get(nomeDoCampo)+"\" ";
		return parametro;
	}
	
	
	public static Map<String,String> obterValoresDosCamposDoCliente(Cliente cliente){
		Map<String, String> campos = new HashMap<>();
		if(cliente.getNome() != null) campos.put("nome", cliente.getNome());
		if(cliente.getCPF() != null) campos.put("CPF", cliente.getCPF());
		if(cliente.getPassaporte() != null) campos.put("passaporte",cliente.getPassaporte());
		if(cliente.getCEP()!= null) campos.put("CEP", cliente.getCEP());
		if(cliente.getTelefone()!= null) campos.put("telefone", cliente.getTelefone());
		if(cliente.getEmail()!= null) campos.put("email", cliente.getEmail());
		
		return campos;
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
