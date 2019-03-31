package controller;

import model.Main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/***
 * 
 * Essa Classe é responsável por exibir todas as telas do sistema
 *
 */


public class ScenesManager {

	 public void mostrarTelaDeLogin() throws IOException {
	    	// Exibe a tela de login
	    	Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
	        Main.primaryStage.setTitle("Você Aluga - Login");
	        Main.primaryStage.setScene(new Scene(root));
	  }
	 
	 public void mostrarTelaPrincipal() throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("../view/TelaPrincipal.fxml"));
	        Main.primaryStage.setTitle("Você Aluga - Principal");
	        Main.primaryStage.setScene(new Scene(root));
	 }

	 
//	 public void mostrarTelaPrincipalGerente() {
//		 
//	 }
}
