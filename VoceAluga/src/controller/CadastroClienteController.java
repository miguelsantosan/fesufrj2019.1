package controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Cliente;
import model.Habilitacao;
import model.server.CadastroCliente;

import java.io.IOException;

import controller.ScenesManager;

public class CadastroClienteController {
	
	ScenesManager manager = new ScenesManager();
	
	@FXML
	TextField campoNome;
	
	@FXML
	MaskField campoCPF;
	
	@FXML
	TextField campoPais;
	
	@FXML
	TextField campoEstado;
	
	@FXML
	DatePicker campoDataDeNascimento;
	
	@FXML
	TextField campoCidade;
	
	@FXML
	TextField campoPassaporte;
	
	@FXML
	TextField campoBairro;
	
	@FXML
	MaskField campoTelefone;
	
	@FXML
	TextField campoRua;
	
	@FXML
	TextField campoEmail;
	
	@FXML
	TextField campoNumero;
	
	@FXML
	MaskField campoCEP;
	
	@FXML
	TextField campoComplemento;
	
	@FXML
	MaskField campoNumeroDeRegistro;
	
	@FXML
	DatePicker campoValidade;
	
	@FXML
	TextField campoCategoria;
	
	@FXML
	DatePicker campoDataDeEmissao;
	
	
	@FXML
	void processarBotaoCancelar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
	
	@FXML
	void processarBotaoConfirmar(MouseEvent e) throws IOException{
		
	}
	
	public void initialize() {
	 	Cliente cliente = CadastroCliente.getClienteAtual();
	 	
	 	preencherCamposComDadosDoCliente(cliente);	
	}
	
	private void preencherCamposComDadosDoCliente(Cliente cliente) {
		Habilitacao habilitacao = cliente.getHabilitacao();
		
		
		campoNome.setText(cliente.getNome());
	 	campoCPF.setPlainText(cliente.getCpf());
	 	campoPais.setText(cliente.getPais());
	 	campoEstado.setText(cliente.getEstado());
	 	campoCidade.setText(cliente.getCidade());
	 	campoPassaporte.setText(cliente.getPassaporte());
	 	campoBairro.setText(cliente.getBairro());
	 	campoTelefone.setPlainText(cliente.getTelefone());
	 	campoRua.setText(cliente.getRua());
	 	campoEmail.setText(cliente.getEmail());
	 	campoNumero.setText(cliente.getNumero());
	 	campoCEP.setPlainText(cliente.getCEP());
	 	campoComplemento.setText(cliente.getComplemento());
	 	
	 	if(cliente.getDataDeNascimento()!=null)
	 		campoDataDeNascimento.setValue(cliente.getDataDeNascimento());

	 	campoNumeroDeRegistro.setPlainText(habilitacao.getNumeroDeRegistro());
	 	campoCategoria.setText(habilitacao.getCategoria());
	 	
	 	if(habilitacao.getDataDeEmissao()!=null)
	 		campoDataDeEmissao.setValue(habilitacao.getDataDeEmissao());
	 	if(habilitacao.getValidade()!=null)
	 		campoValidade.setValue(habilitacao.getValidade());
	}
	
}
