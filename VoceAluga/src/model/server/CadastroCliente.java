package model.server;

import java.util.ArrayList;

import model.Cliente;

public class CadastroCliente {
	private static ArrayList<Cliente> clientesBuscados;
	private static Cliente clienteAtual;
	
	// CODIGO DE TESTE
	public static void buscarClientes(Cliente cliente){
		clientesBuscados = new ArrayList<Cliente>();
		clientesBuscados.add(new Cliente("cliente1","12345678900"));
		clientesBuscados.add(new Cliente("cliente2","98765432100"));
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
