package model.server;

import java.util.ArrayList;

import model.Cliente;

public class cadastroCliente {
	private static ArrayList<Cliente> clientesBuscados;
	private static Cliente clienteAtual;
	
	
	public static void buscarClientes(Cliente cliente){
		clientesBuscados = new ArrayList<Cliente>();
	}
	
	public static ArrayList<Cliente> getClientesBuscados() {
		return clientesBuscados;
	}
	
	public static void buscarPorCPF(String CPF) {
		clienteAtual = new Cliente();
	}
	
	public static Cliente clienteAtual() {
		return clienteAtual;
	}

}
