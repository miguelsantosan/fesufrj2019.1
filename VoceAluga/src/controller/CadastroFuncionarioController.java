package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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


}
