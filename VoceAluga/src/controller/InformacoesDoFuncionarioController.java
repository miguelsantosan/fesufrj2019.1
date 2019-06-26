package controller;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import model.Funcionario;
import model.dao.CadastroFuncionario;

public class InformacoesDoFuncionarioController {

	ScenesManager manager = new ScenesManager();
	
    @FXML
    private Button BotaoVoltar;

    @FXML
    private Button BotaoAlterarCadastro;

    @FXML
    private Label LabelCPF;

    @FXML
    private Label LabelNome;

    @FXML
    private Label LabelCargo;

    @FXML
    private Label LabelLogin;

    @FXML
    private Button BotaoAlterarCadastro1;

    @FXML
    private Button BotaoExcluirFuncionario;

    @FXML
    void processarBotaoAlterarCadastro(MouseEvent event) {
    	manager.mostrarTelaCadastroDeFuncionario();	
    }

    @FXML
    void processarBotaoExcluirFuncionario(MouseEvent event) {
    	 Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Deletar Dados Do Funcionário");
		 alert.setHeaderText("Atenção, essa operação é irreversível!");
		 alert.setContentText("Deseja Continuar?");

		 Optional<ButtonType> result = alert.showAndWait();
		 if (result.get() == ButtonType.OK){
		    if(CadastroFuncionario.deletarFuncionario(CadastroFuncionario.getFuncionarioAtual().getCPF())){
		    	mostrarMensagemDeSucesso("Funcionario deletado com sucesso");
		    	manager.mostrarTelaPrincipal();
		    }
		    else{
		    	mostrarMensagemDeErro("Não foi possível deletar o funcionário");
		    }
		    
	    } 
    }

    @FXML
    void processarBotaoRedefinirSenha(MouseEvent event) {
    	System.err.println("botao redefinir senha não implementado");
    }

    @FXML
    void processarBotaoVoltar(MouseEvent event) {
    	manager.mostrarTelaPrincipal();
    }
    
    @FXML
    public void initialize() {
	 	Funcionario funcionario = CadastroFuncionario.getFuncionarioAtual();
	 	
	 	preencherLabelsComDadosDoFuncionario(funcionario);
	}
    
    private void preencherLabelsComDadosDoFuncionario(Funcionario funcionario) {
    	
		if(funcionario.getNome()!=null)LabelNome.setText(funcionario.getNome());
		if(funcionario.getCPF()!=null) LabelCPF.setText(funcionario.getCPFFormatado());
	 	
		if(funcionario.getLogin()!=null) LabelLogin.setText(funcionario.getLogin());
		if(funcionario.getCargo()!=null) LabelCargo.setText(funcionario.getCargo());

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


}
