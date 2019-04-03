package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;



import controller.ScenesManager;
import model.Cliente;



public class ResultadosBuscaClienteController {
	
	ScenesManager manager = new ScenesManager();
	
	
	ObservableList<Cliente> listaDeClientes = FXCollections.observableArrayList();
	@FXML
	ListView<Cliente> lista;
	
	
	
	public void initialize() {
		//criando dois clientes para teste
		listaDeClientes.add(new Cliente("abc","123"));
		listaDeClientes.add(new Cliente("def","456"));
		
		ListView<Cliente> lista2 = new ListView<>(listaDeClientes);
		
		
		lista2.setCellFactory(param -> new ListCell<Cliente>() {
           
			@Override
            protected void updateItem(Cliente c, boolean empty) {
                super.updateItem(c, empty);
                setText(c.getNome());
                
            }
        
		});
		lista.setItems(listaDeClientes);
		
		
			
			
		
	}

	@FXML
	void processarBotaoVoltar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
}
