package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

import model.Veiculo;
import model.dao.CadastroCliente;
import model.dao.CadastroVeiculo;
import model.dao.ValidadorDeLogin;
import model.Cliente;
import model.Funcionario;
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
	 private TextField CampoNome;
	 
	 @FXML
	 private TextField CampoCPF;
	 
	 @FXML
	 private TextField CampoPassaporte;
	 
	 @FXML
	 private TextField CampoCEP;
	 
	 @FXML
	 private TextField CampoTelefone;
	 
	 @FXML
	 private TextField CampoEmail;

	@FXML
	private TextField CampoFilial;

	@FXML
	private TextField CampoChassi;

	@FXML
	private TextField CampoPlaca;

	@FXML
	private TextField CampoMarca;

	@FXML
	private TextField CampoAnoDeFabricacao;

	@FXML
	private TextField CampoClasse;
	 
	 
	 
	 
	 
	 @FXML
	 void processarBotaoCadastrarNovoCliente(MouseEvent e) throws IOException {
		 CadastroCliente.setClienteAtual(null);
		 manager.mostrarTelaCadastroDeCliente();
	 }
	 
	 //NAOIMPLEMENTADO
	 @FXML
	 void processarBotaoBuscarCliente(MouseEvent e) throws IOException{
		 	String nome = CampoNome.getText();
		 	String CPF = CampoCPF.getText().trim();
		 	String passaporte = CampoPassaporte.getText().trim();
		 	String CEP = CampoCEP.getText().trim();
		 	String email = CampoEmail.getText().trim();
		 	String telefone = CampoTelefone.getText();
		 	
		 	Cliente cliente= new Cliente();
		 	
		 	if(!telefone.equals("")) cliente.setTelefone(telefone);
		 	if(!CPF.equals("")) cliente.setCpf(CPF);
		 	if(!nome.equals("")) cliente.setNome(nome);
		 	if(!passaporte.equals("")) cliente.setPassaporte(passaporte);
		 	if(!CEP.equals("")) cliente.setCEP(CEP);
		 	if(!email.equals("")) cliente.setEmail(email);
		 	
		 	CadastroCliente.buscarClientes(cliente);
		 	
		 	if(CadastroCliente.getClientesBuscados() != null)
		 		manager.mostrarTelaResultadosBuscaCliente();
		 	else 
		 		exibirErroNenhumClienteEncontrado();
	 }
	 
	 
	private void exibirErroNenhumClienteEncontrado() {
		Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Erro");
    	alert.setHeaderText("Nenhum cliente corresponde aos campos informados.");
    	alert.setContentText("");
    	alert.showAndWait();
    	
    	CampoNome.setText("");
    	CampoCPF.setText("");
    	CampoPassaporte.setText("");
    	CampoCEP.setText("");
    	CampoTelefone.setText("");
    	CampoEmail.setText("");
    	
		
	}

	//NAOIMPLEMENTADO
	 @FXML
	 public void processarBotaoBuscarVeiculo(MouseEvent e) throws IOException {
	 	String filial = CampoFilial.getText();
	 	String chassi = CampoChassi.getText();
	 	String placa = CampoPlaca.getText();
	 	String marca = CampoMarca.getText();
	 	String ano = CampoAnoDeFabricacao.getText();
	 	String classe = CampoClasse.getText();

	 	Veiculo veiculo = new Veiculo();

		 if(!filial.equals("")) veiculo.setFilial(filial);
		 if(!chassi.equals("")) veiculo.setChassi(chassi);
		 if(!placa.equals("")) veiculo.setPlaca(placa);
		 if(!marca.equals("")) veiculo.setMarca(marca);
		 if(!ano.equals("")) {
			try {
				veiculo.setAnoDeFabricacao(Integer.parseInt(ano));
			} catch (NumberFormatException nfe) {
				System.err.println("Erro na formatacao do Ano de Fabricacao do Veiculo");
			}
		 }
		 if(!classe.equals("")) veiculo.setClasse(marca.charAt(0));

		 CadastroVeiculo.buscarVeiculos(veiculo);
		 manager.mostrarTelaResultadosBuscaVeiculo();
	 }

	 @FXML
	 void processarBotaoCadastrarNovoVeiculo(MouseEvent e) throws IOException {
		CadastroVeiculo.setVeiculoAtual(new Veiculo());
		manager.mostrarTelaCadastroDeVeiculo();
	 }
	 
	 
	 public void initialize() {
		 Funcionario funcionarioLogado = ValidadorDeLogin.getFuncionarioLogado();
		 
		 int nivel = funcionarioLogado.getNivelDeAcesso();
		 usuario.setText(funcionarioLogado.getNome());
		 cargo.setText(funcionarioLogado.getCargo());
		 NivelDeAcesso.setText(Integer.toString(nivel));
		 
		 tabClientes.setDisable(false);
		 
		 
		 
		 if (nivel  <= 1) {
			 	
	        	tabVeiculos.setDisable(true);;
	        	tabFuncionarios.setDisable(true);
		 }
		 else {
			 tabVeiculos.setDisable(false);;
	         tabFuncionarios.setDisable(false);
		 }
		 
	}
}
