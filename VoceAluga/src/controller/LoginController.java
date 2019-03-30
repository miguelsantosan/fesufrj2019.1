package controller;

import model.Funcionario;
import model.server.ValidadorDeLogin;
//import model.Main;


import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class LoginController {
	
//	private Main main= new Main();

    @FXML
    private TextField user;
    
    @FXML
    private PasswordField password;
    
    @FXML
   	void processarLoginBotao(MouseEvent e) throws IOException {
       	if(ValidadorDeLogin.validarLogin(user.getText(),password.getText())) {
       		Funcionario funcionarioAtual = ValidadorDeLogin.getFuncionario(user.getText()); 
       		System.out.println(funcionarioAtual.getNivelDeAcesso());
       	}
       	else {
       		mostrarErroDeLogin();
       	}
   }
    
    public void mostrarErroDeLogin() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Erro");
    	alert.setHeaderText("Erro");
    	alert.setContentText("Login ou usuário inválido");
    	alert.showAndWait();
    	user.setText("");
    	password.setText("");
    }

    public void initialize() {
    	
    }
    
    
}