package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;

import javafx.scene.input.MouseEvent;


import java.util.ArrayList;

import controller.ScenesManager;
import model.Cliente;


public class ResultadosBuscaClienteController {
	

	
	ScenesManager manager = new ScenesManager();
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
	
	public static final ObservableList<Object> data = FXCollections.observableArrayList();
	final ListView<Cliente> listView = new ListView<Cliente>();
	
	public void initialize() {
		
			
			
			
		
	}

	@FXML
	void processarBotaoVoltar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
}
