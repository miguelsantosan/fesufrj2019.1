package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
		System.out.println("clique");
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
