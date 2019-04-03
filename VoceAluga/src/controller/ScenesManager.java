package controller;


import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/***
 * 
 * Essa Classe é responsável por exibir todas as telas do sistema
 *
 */


public class ScenesManager {
	
	public static Stage primaryStage =  new Stage();

	 public void mostrarTelaDeLogin() throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
	    	primaryStage.setResizable(false);
	    	primaryStage.initStyle(StageStyle.UNIFIED);
	        primaryStage.setTitle("Você Aluga - Login");
	        primaryStage.setScene(new Scene(root));
	  }
	 
	 public void mostrarTelaPrincipal() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/TelaPrincipal.fxml"));
	        primaryStage.setTitle("Você Aluga - Principal");
	        primaryStage.setScene(new Scene(root));
	 }
	 
	 public void mostrarTelaCadatroDeCliente() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/CadastroCliente.fxml"));
	        primaryStage.setTitle("Você Aluga - Cadastrar Cliente");
	        primaryStage.setScene(new Scene(root));
	 }
	 
	 public void mostrarResultadosBuscaCliente() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/ResultadosBuscaCliente.fxml"));
	        primaryStage.setTitle("Você Aluga - Busca de Clientes");
	        primaryStage.setScene(new Scene(root));
	 }

}
