package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import model.Cliente;
import model.Habilitacao;
import model.dao.CadastroCliente;

import java.io.IOException;
import java.util.TreeMap;

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
	MaskField campoCategoria;
	
	@FXML
	DatePicker campoDataDeEmissao;
	
	
	
	@FXML
	void processarBotaoCancelar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
	
	 TreeMap<String,String> gerarMapAPartirDoFormulario(){
		TreeMap<String,String> campos = new TreeMap<>();
		
		if(campoNome.getText() != null) campos.put("nome",campoNome.getText());
		if(!campoCPF.getPlainText().equals("")) campos.put("CPF", campoCPF.getPlainText());
		
		if(campoPais.getText() != null) campos.put("pais", campoPais.getText());
		if(campoEstado.getText() != null) campos.put("estado", campoEstado.getText());
		if(campoDataDeNascimento.getValue()!=null) campos.put("dataDeNascimento", campoDataDeNascimento.getValue().toString());
		if(campoCidade.getText() != null) campos.put("cidade", campoCidade.getText());
		if(campoPassaporte.getText() !=null) campos.put("passaporte", campoPassaporte.getText());
		if(campoBairro.getText() != null) campos.put("bairro", campoBairro.getText());
		if(!campoTelefone.getPlainText().equals("")) campos.put("telefone", campoTelefone.getPlainText());
		if(campoRua.getText() != null) campos.put("rua", campoRua.getText());
		if(campoEmail.getText() != null) campos.put("email", campoEmail.getText());
		if(campoNumero.getText() != null) campos.put("numero", campoNumero.getText());
		if(!campoCEP.getPlainText().equals("")) campos.put("CEP", campoCEP.getPlainText());
		if(campoComplemento.getText() !=null) campos.put("complemento", campoComplemento.getText());
		
		if(!campoNumeroDeRegistro.getPlainText().equals("")) campos.put("numeroDeRegistro", campoNumeroDeRegistro.getPlainText());
		if(campoValidade.getValue()!=null) campos.put("validade", campoValidade.getValue().toString());
		if(!campoCategoria.getPlainText().equals("")) campos.put("categoria", campoCategoria.getPlainText());
		if(campoDataDeEmissao.getValue()!=null) campos.put("dataDeEmissao", campoDataDeEmissao.getValue().toString());
		return campos;
	}
	 

	
	@FXML
	void processarBotaoConfirmar(MouseEvent e) throws IOException{
		TreeMap<String,String> campos = gerarMapAPartirDoFormulario();
		
		if(campos.containsKey("CPF") && !Cliente.ValidarCPF(campos.get("CPF"))){
			mostrarErroDeCadastro("CPF inválido");
		}
		else{
			if(CadastroCliente.cadastrarCliente(campos)){
				mostrarMensagemDeSucesso();
				manager.mostrarTelaPrincipal();
			}
			else{
				mostrarErroDeCadastro("Não foi possível cadastrar o cliente");
			}
		}
		
		
	}
	
	public void mostrarMensagemDeSucesso() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Cadastro bem sucedido");
    	alert.setHeaderText("Cliente cadastrado com sucesso");
    	alert.setContentText("");
    	alert.showAndWait();
    }
	
	
    public void mostrarErroDeCadastro(String mensagem) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Erro no Cadastro");
    	alert.setHeaderText("");
    	alert.setContentText( mensagem);
    	alert.showAndWait();
    }
	
	
	
	public void initialize() {
	 	Cliente cliente = CadastroCliente.getClienteAtual();
	 	
	 	preencherCamposComDadosDoCliente(cliente);	
	}
	
	private void preencherCamposComDadosDoCliente(Cliente cliente) {
		Habilitacao habilitacao = cliente.getHabilitacao();
		
		
		campoNome.setText(cliente.getNome());
	 	campoCPF.setPlainText(cliente.getCPF());
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
	 	campoCategoria.setPlainText(habilitacao.getCategoria());
	 	
	 	if(habilitacao.getDataDeEmissao()!=null)
	 		campoDataDeEmissao.setValue(habilitacao.getDataDeEmissao());
	 	if(habilitacao.getValidade()!=null)
	 		campoValidade.setValue(habilitacao.getValidade());
	}
	
}
