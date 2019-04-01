package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import controller.ScenesManager;

public class CadastroClienteController {
	
	ScenesManager manager = new ScenesManager();
	
	@FXML
	void processarBotaoCancelar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
	
	@FXML
	void processarBotaoConfirmar(MouseEvent e) throws IOException{
		
	}
	
	
}
