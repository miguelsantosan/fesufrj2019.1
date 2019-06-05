package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListView;

import controller.ScenesManager;
import model.Funcionario;
import model.dao.CadastroFuncionario;




public class ResultadosBuscaFuncionarioController {
	
	ScenesManager manager = new ScenesManager();
	
	
	ObservableList<Funcionario> listaDeFuncionariosBuscados = FXCollections.observableArrayList();
	
	@FXML
	ListView<String> listaExibidaNaTela;
	
	@FXML
	void processarBotaoConfirmar(MouseEvent e) throws IOException {
		int indexDoFuncionarioSelecionado = listaExibidaNaTela.getSelectionModel().getSelectedIndex();
		
		if(indexDoFuncionarioSelecionado!= -1) {
			CadastroFuncionario.setFuncionarioAtual(listaDeFuncionariosBuscados.get(indexDoFuncionarioSelecionado));
			manager.mostrarTelaInformacoesDoFuncionario();
		}
	}
	
	@FXML
	void processarBotaoCancelar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
	

	
	
	
	public void initialize() {
		
		//gera lista de funcionarios com nome e cpf e exibe no elemento listaExibidaNaTela
		
		listaDeFuncionariosBuscados.addAll(CadastroFuncionario.getFuncionariosBuscados());
		ObservableList <String> listaDeNomesDeClientesBuscados = FXCollections.observableArrayList();
		
		listaDeFuncionariosBuscados.forEach(funcionario ->{
			listaDeNomesDeClientesBuscados.add(funcionario.getNome() +"   "+funcionario.getCPFFormatado());
		});


		listaExibidaNaTela.setItems(listaDeNomesDeClientesBuscados);
		
	}

	
}
