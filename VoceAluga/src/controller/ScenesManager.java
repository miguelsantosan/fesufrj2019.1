package controller;


import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/***
 * 
 * Essa Classe e responsavel por exibir todas as telas do sistema
 *
 */


public class ScenesManager {
	
	public static Stage primaryStage =  new Stage();

	 public void mostrarTelaDeLogin() throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
	    	primaryStage.setResizable(false);
	    	primaryStage.initStyle(StageStyle.UNIFIED);
	        primaryStage.setTitle("Voce Aluga - Login");
	        primaryStage.setScene(new Scene(root));
	  }
	 
	 public void mostrarTelaPrincipal() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/TelaPrincipal.fxml"));
	        primaryStage.setTitle("Voce Aluga - Principal");
	        primaryStage.setScene(new Scene(root));
	 }
	 
	 public void mostrarTelaCadatroDeCliente() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/CadastroCliente.fxml"));
	        primaryStage.setTitle("Voce Aluga - Cadastrar Cliente");
	        primaryStage.setScene(new Scene(root));
	 }
	 
	 public void mostrarTelaResultadosBuscaCliente() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/ResultadosBuscaCliente.fxml"));
	        primaryStage.setTitle("Voce Aluga - Busca de Clientes");
	        primaryStage.setScene(new Scene(root));
	 }
	 
	 public void mostrarTelaInformacoesDoCliente() throws IOException{
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/InformacoesDoCliente.fxml"));
		 	primaryStage.setTitle("Voce Aluga - Dados do Cliente");
	        primaryStage.setScene(new Scene(root));
	 }
	 
	 public void mostrarTelaCadastroDeVeiculo() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/CadastroVeiculo.fxml"));
	        primaryStage.setTitle("Voce Aluga - Cadastrar Veiculo");
	        primaryStage.setScene(new Scene(root));
	 }
	 
	 public void mostrarTelaResultadosBuscaVeiculo() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/ResultadosBuscaVeiculo.fxml"));
	        primaryStage.setTitle("Voce Aluga - Cadastrar Veiculo");
	        primaryStage.setScene(new Scene(root));
	 }

}
