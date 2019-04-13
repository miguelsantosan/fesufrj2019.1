package model.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Essa classe é responsável por abrir e fechar a conexao com o servidor
 */

public class MySQLConnector {
	final private static String driver = "com.mysql.cj.jdbc.Driver";
    final private static String enderecoServidor = "remotemysql.com"; 
    final private static String usuario = "V0Q2C5knzI"; 
    final private static String senha = "MO7nFZAUQX";
    final private static String nomeDoBancoDeDados = "V0Q2C5knzI";
    
    public static Connection connection = null;

    public static void abrirConexao(){
        try {
            Class.forName(driver).newInstance();
            System.out.println("Driver carregado");
        } catch (Exception e) {
            System.err.println("Nao foi possivel carregar o driver do mysql");
            System.err.println(e);
        }

        try {
            connection = DriverManager.getConnection( 
            		"jdbc:mysql://"+enderecoServidor+"/"+nomeDoBancoDeDados , usuario, senha );
            System.out.println("Conexao com o banco de dados estabelecida successfully");   
        } catch (Exception e) {
            System.err.println("Nao foi possivel estabelecer a conexao");
            System.err.println(e);
        }
}
  
 public static void fecharConexao(){
	try {
		connection.close();
		System.out.println("Conexao Fechada");
	} catch (SQLException e) {
		 System.err.println("Nao foi possivel fechar a conexao");
         
	}
 }
}
