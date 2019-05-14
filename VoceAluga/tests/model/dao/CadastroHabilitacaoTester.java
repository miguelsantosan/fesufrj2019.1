package model.dao;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CadastroHabilitacaoTester {

	@Before
	public void before(){
		MySQLConnector.abrirConexao();
	}
	
	@Test
	public void testCadastrarHabilitacao(){ 
		TreeMap<String,String> campos = new TreeMap<>();
		campos.put("numeroDeRegistro", "11111111111");
		campos.put("categoria","B");
		campos.put("dataDeEmissao", "1999-02-02");
		campos.put("validade", "2001-02-03");
		assertTrue(CadastroHabilitacao.cadastrarHabilitacao(campos));
		
		assertTrue(CadastroHabilitacao.buscarHabilitacaoPorNumeroDeRegistro("11111111111"));
		assertEquals("11111111111",CadastroHabilitacao.habilitacaoAtual.getNumeroDeRegistro());
		assertEquals("B",CadastroHabilitacao.habilitacaoAtual.getCategoria());	
		
		assertTrue(CadastroHabilitacao.deletarHabilitacao("11111111111"));
		assertTrue(!CadastroHabilitacao.buscarHabilitacaoPorNumeroDeRegistro("11111111111"));
	}


	
	@After
	public void after(){
		MySQLConnector.fecharConexao();
	}

}
