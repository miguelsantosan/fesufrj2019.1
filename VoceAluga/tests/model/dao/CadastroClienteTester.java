package model.dao;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import model.Cliente;
import model.dao.CadastroCliente;

public class CadastroClienteTester {
	Cliente cliente1,cliente2;
	
	@Before
	public void criarDoisCliente(){
		cliente1 = new Cliente("Joaquim","17181426095","12378","12345678","552189898989",null);
		cliente2 = new Cliente(null,null,null,null,null,null);
	}

	@Test
	public void testObterValoresDosCamposDoCliente() {
		
		Map<String,String> output1 = CadastroCliente.obterValoresDosCamposDoCliente(cliente1);
		
		
		Map<String,String> output2 = CadastroCliente.obterValoresDosCamposDoCliente(cliente2);
		
		assertEquals(output1.get("nome"),"Joaquim");
		assertEquals(output1.size(),5);
		
		assertEquals(output2.size(),0);
		assertEquals(output2.get("CPF"),null);
		assertEquals(output2.containsKey("CEP"),false);
	
	}
	
	@Test 
	public void testAdicionarParametrosAoStatement(){
		Map<String,String> campos2 = CadastroCliente.obterValoresDosCamposDoCliente(cliente2);
		
		String statement = "SELECT * FROM table";
		
		String output2 =CadastroCliente.adicionarParametrosQueryDeBusca(statement, campos2);
		
		
		assertEquals(statement,output2);
	}

}
