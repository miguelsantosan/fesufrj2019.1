package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import controller.ScenesManager;

public class ResultadosBuscaClienteController {
	ScenesManager manager = new ScenesManager();

	@FXML
	void processarBotaoVoltar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
}
