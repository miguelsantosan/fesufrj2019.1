package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

import model.server.ValidadorDeLogin;
import controller.ScenesManager;

public class TelaPrincipalController {
	
	ScenesManager manager = new ScenesManager();
		
	 @FXML
	 private Label usuario;
	 
	 @FXML
	 private Label cargo;
	 
	 @FXML
	 private Label NivelDeAcesso;
	 
	 @FXML
	 private TabPane painel;
	 
	 @FXML
	 private Tab tabClientes;
	 
	 @FXML
	 private Tab tabVeiculos;
	 
	 @FXML
	 private Tab tabFuncionarios;
	 
	 
	 @FXML
	 void processarBotaoCadastrarNovoCliente(MouseEvent e) throws IOException {
	       manager.mostrarTelaCadatroDeCliente();
	 }
	 
	 
	 
	 public void initialize() {
		 
		 int nivel = ValidadorDeLogin.FuncionarioLogado.getNivelDeAcesso();
		 usuario.setText(ValidadorDeLogin.FuncionarioLogado.getNome());
		 cargo.setText(ValidadorDeLogin.FuncionarioLogado.getCargo());
		 NivelDeAcesso.setText(Integer.toString(nivel));
		 
		 tabClientes.setDisable(false);
		 
		 
		 
		 if (nivel == 1) {
			 	
	        	tabVeiculos.setDisable(true);;
	        	tabFuncionarios.setDisable(true);
		 }
		 else {
			 tabVeiculos.setDisable(false);;
	         tabFuncionarios.setDisable(false);
		 }
		 
	}
}
