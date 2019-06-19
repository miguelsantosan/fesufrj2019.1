package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    	
    }

    @FXML
    void processarBotaoExcluirFuncionario(MouseEvent event) {
    	
    }

    @FXML
    void processarBotaoRedefinirSenha(MouseEvent event) {
    	System.err.println("botao redefinir senha não implementado");
    }

    @FXML
    void processarBotaoVotar(MouseEvent event) {
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


}
