package controller;


import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import model.Cliente;
import model.Habilitacao;
import model.dao.CadastroCliente;

public class InformacoesDoClienteController {
	ScenesManager manager = new ScenesManager();
	
	@FXML
	Label labelNome;
	
	@FXML
	Label labelCPF;
	
	@FXML
	Label labelPais;
	
	@FXML
	Label labelEstado;
	
	@FXML
	Label labelDataDeNascimento;
	
	@FXML
	Label labelCidade;
	
	@FXML
	Label labelPassaporte;
	
	@FXML
	Label labelBairro;
	
	@FXML
	Label labelTelefone;
	
	@FXML
	Label labelRua;
	
	@FXML
	Label labelEmail;
	
	@FXML
	Label labelNumero;
	
	@FXML
	Label labelCEP;
	
	@FXML
	Label labelComplemento;
	
	@FXML
	Label labelNumeroDeRegistro;
	
	@FXML
	Label labelValidade;
	
	@FXML
	Label labelCategoria;
	
	@FXML
	Label labelDataDeEmissao;
	
	@FXML
	public void processarBotaoVoltar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
	
	@FXML
	public void processarBotaoEditar(MouseEvent e) throws IOException {
		manager.mostrarTelaCadastroDeCliente();
	}
	
	@FXML 
	public void processarBotaoDeletar(MouseEvent e) throws IOException{
		 Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Deletar Dados Do Cliente");
		 alert.setHeaderText("Atenção, essa operação é irreversível!");
		 alert.setContentText("Deseja Continuar?");

		 Optional<ButtonType> result = alert.showAndWait();
		 if (result.get() == ButtonType.OK){
		    if(CadastroCliente.deletarCliente(CadastroCliente.getClienteAtual().getCPF())){;
		    	mostrarMensagemDeSucesso("Cliente deletado com sucesso");
		    	manager.mostrarTelaPrincipal();
		    }
		    else{
		    	mostrarMensagemDeErro("Não foi possível deletar o cliente");
		    }
		    
	    } 
	}

	  public void mostrarMensagemDeSucesso(String mensagem) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("");
	    	alert.setHeaderText(mensagem);
	    	alert.setContentText("");
	    	alert.showAndWait();
	    }
	  public void mostrarMensagemDeErro(String mensagem) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("");
	    	alert.setHeaderText(mensagem);
	    	alert.setContentText("");
	    	alert.showAndWait();
	    }
	
	
	public void initialize() {
	 	Cliente cliente = CadastroCliente.getClienteAtual();
	 	
	 	preencherLabelsComDadosDoCliente(cliente);
	}
	
	private void preencherLabelsComDadosDoCliente(Cliente cliente) {
		Habilitacao habilitacao = cliente.getHabilitacao();
		
		
		if(cliente.getNome()!=null)labelNome.setText(cliente.getNome());
		if(cliente.getCPF()!=null)labelCPF.setText(cliente.getCPFFormatado());
	 	
		if(cliente.getPais()!=null)labelPais.setText(cliente.getPais());
		if(cliente.getEstado()!=null)labelEstado.setText(cliente.getEstado());
		if(cliente.getCidade()!=null)labelCidade.setText(cliente.getCidade());
		if(cliente.getPassaporte()!=null)labelPassaporte.setText(cliente.getPassaporte());
		if(cliente.getBairro()!=null)labelBairro.setText(cliente.getBairro());
		if(cliente.getTelefone()!=null)labelTelefone.setText(cliente.getTelefoneFormatado());
		if(cliente.getRua()!=null)labelRua.setText(cliente.getRua());
		if(cliente.getEmail()!=null)labelEmail.setText(cliente.getEmail());
		if(cliente.getNumero()!=null)labelNumero.setText(cliente.getNumero());
		if(cliente.getCEP()!=null)labelCEP.setText(cliente.getCEPFormatado());
		if(cliente.getComplemento()!=null)labelComplemento.setText(cliente.getComplemento());
	 	if(cliente.getDataDeNascimento()!=null)
	 		labelDataDeNascimento.setText(cliente.getDataDeNascimento().toString());

	 	if(cliente.getHabilitacao()!=null){
		 	labelNumeroDeRegistro.setText(habilitacao.getNumeroDeRegistro());
		 	labelCategoria.setText(habilitacao.getCategoria());
		 	if(habilitacao.getDataDeEmissao()!=null)
		 		labelDataDeEmissao.setText(habilitacao.getDataDeEmissao().toString());
		 	if(habilitacao.getValidade()!=null)
	 		labelValidade.setText(habilitacao.getValidade().toString());
	 	}
	 
	}
	

}
