package controller;

import java.io.IOException;
import java.util.TreeMap;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import model.Funcionario;
import model.dao.CadastroFuncionario;

public class CadastroFuncionarioController {
	
	ScenesManager manager = new ScenesManager();

    @FXML
    private TextField CampoCPF;

    @FXML
    private TextField CampoNome;

    @FXML
    private TextField CampoCargo;

    @FXML
    private TextField CampoLogin;
    
    @FXML
    private Label LabelSenha;
    
    @FXML
    private Label LabelConfirmacaoSenha;

    @FXML
    private PasswordField CampoSenha;

    @FXML
    private PasswordField CampoConfirmacaoSenha;

    @FXML
    private Button BotaoCancelar;

    @FXML
    private Button BotaoConfirmar;
    
    
    @FXML
    void processarBotaoConfirmar(MouseEvent e) throws IOException{
    	if(CadastroFuncionario.getFuncionarioAtual()==null){
			 System.out.println("Cadastrando funcionario");
			 adicionarFuncionario();
		 }else{
			 System.out.println("alterando funcionario");
			 alterarFuncionario();
		 }
	}
    
    void adicionarFuncionario() throws IOException{
		
		if(validarCamposCadastro() == false) return;
		System.out.println("TESTE");
		
		TreeMap<String,String> camposFuncionario = gerarMapAPartirDoFormulario();
		
		if(CadastroFuncionario.cadastrarFuncionario(camposFuncionario)){
			mostrarMensagemDeSucesso("Funcionário cadastrado com sucesso");
			manager.mostrarTelaPrincipal();
		}
		else{
			mostrarErroDeCadastro("Não foi possível cadastrar o funcionário");
		}

	}
    
    void alterarFuncionario() throws IOException{
    	if(validarCamposEdicao() == false) return;
    	
    	TreeMap<String,String> camposFuncionario = gerarMapAPartirDoFormulario();
		
    	if(CadastroFuncionario.alterarFuncionario(camposFuncionario)){
			mostrarMensagemDeSucesso("Cadastro alterado com sucesso");
			manager.mostrarTelaPrincipal();
		}
		else{
			mostrarErroDeCadastro("Não foi possível alterar o cadastro do Funcionario");
		}
    }
    
     private TreeMap<String,String> gerarMapAPartirDoFormulario(){
    	TreeMap<String,String> DadosDoFuncionario = new TreeMap<>();
    	String nome,login,cpf,senha,cargo;
    	
    	nome = CampoNome.getText();
    	login = CampoLogin.getText();
    	senha = CampoSenha.getText();
    	cpf = CampoCPF.getText();
    	cargo = CampoCargo.getText();
    	
    	
    	if(CampoNome.getText() != null) DadosDoFuncionario.put("nome", nome);
		if(CampoLogin.getText() != null) DadosDoFuncionario.put("login", login);
		if(CampoSenha.getText() != null) DadosDoFuncionario.put("senha", senha);
		if(CampoCPF.getText() != null) DadosDoFuncionario.put("CPF", cpf);
		if(CampoCargo.getText() != null) DadosDoFuncionario.put("cargo", cargo);
		
		///DEFINFINDO NIVEL 1 COMO DEFAULT
		DadosDoFuncionario.put("nivelDeAcesso","1");
    	
		return DadosDoFuncionario;
    }
     
     
     
     
    private boolean validarCamposCadastro(){
    	String nome,login,cpf,senha,confirmacaoSenha,cargo;
    	
    	nome = CampoNome.getText();
    	login = CampoLogin.getText();
    	senha = CampoSenha.getText();
    	cpf = CampoCPF.getText();
    	cargo = CampoCargo.getText();
    	confirmacaoSenha = CampoConfirmacaoSenha.getText();
    	
    	if(nome==null || login==null || senha==null || cpf==null || cargo==null ||
    		senha.equals("") || nome.equals("") || login.equals("") || cpf.equals("") || cargo.equals("")){
    		mostrarErroDeCadastro("Preencha todos os campos");
    		return false;
    	}
    	if(!senha.equals(confirmacaoSenha)){
    		mostrarErroDeCadastro("A senha e a confirmação de senha estão diferentes");
    		return false;
    	}
    	return true;
    }
    
    private boolean validarCamposEdicao(){
    	String nome,login,cpf,cargo;
    	
    	nome = CampoNome.getText();
    	login = CampoLogin.getText();
    	cpf = CampoCPF.getText();
    	cargo = CampoCargo.getText();
    	
    	if(nome==null || login==null ||  cpf==null || cargo==null ||
    	   nome.equals("") || login.equals("") || cpf.equals("") || cargo.equals("")){
    	   mostrarErroDeCadastro("Preencha todos os campos");
    		return false;
    	}
    	return true;
    }
    
    public void mostrarMensagemDeSucesso(String mensagem) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Cadastro bem sucedido");
    	alert.setHeaderText(mensagem);
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
    
    @FXML
	void processarBotaoCancelar(MouseEvent e) throws IOException {
		manager.mostrarTelaPrincipal();
	}
    
    @FXML
    public void initialize() {
		if(CadastroFuncionario.getFuncionarioAtual()!=null){
			Funcionario funcionario = CadastroFuncionario.getFuncionarioAtual();
	 		preencherCamposComDadosDoFuncionario(funcionario);	
	 		CampoCPF.setDisable(true);
	 		CampoSenha.setVisible(false);
	 		CampoConfirmacaoSenha.setVisible(false);
	 		LabelSenha.setVisible(false);
	 		LabelConfirmacaoSenha.setVisible(false);
		}
	}
    
    private void preencherCamposComDadosDoFuncionario(Funcionario funcionario) {
		
		CampoNome.setText(funcionario.getNome());
	 	CampoCPF.setText(funcionario.getCPF());
	 	CampoCargo.setText(funcionario.getCargo());
	 	CampoLogin.setText(funcionario.getLogin());
	 	
	}


}
