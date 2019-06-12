package controller;


import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import model.Veiculo;
import model.dao.CadastroVeiculo;

public class InformacoesDoVeiculoController {

    ScenesManager manager = new ScenesManager();
    @FXML
    private Label labelInformacoesAdicionais;

    @FXML
    private Label labelMarca;

    @FXML
    private Label labelModelo;

    @FXML
    private Label labelAno;

    @FXML
    private Label labelPlaca;

    @FXML
    private Label labelQuilometragem;

    @FXML
    private Label labelChassi;

    @FXML
    private Label labelRENAVAM;

    @FXML
    private Label labelClasse;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelManutencao;

    @FXML
    void processarBotaoDeletar(MouseEvent event) {

    }

    @FXML
    void processarBotaoEditar(MouseEvent event) {

    }

    @FXML
    void processarBotaoVoltar(MouseEvent event) {

    }

    public void initialize() {
        Veiculo veiculo = CadastroVeiculo.getVeiculoAtual();

        preencherLabelsComDadosDoVeiculo(veiculo);
    }

    private void preencherLabelsComDadosDoVeiculo(Veiculo veiculo) {
        Habilitacao habilitacao = veiculo.getHabilitacao();


        if(veiculo.getNome()!=null)labelNome.setText(veiculo.getNome());
        if(veiculo.getCPF()!=null)labelCPF.setText(veiculo.getCPFFormatado());

        if(veiculo.getPais()!=null)labelPais.setText(veiculo.getPais());
        if(veiculo.getEstado()!=null)labelEstado.setText(veiculo.getEstado());
        if(veiculo.getCidade()!=null)labelCidade.setText(veiculo.getCidade());
        if(veiculo.getPassaporte()!=null)labelPassaporte.setText(veiculo.getPassaporte());
        if(veiculo.getBairro()!=null)labelBairro.setText(veiculo.getBairro());
        if(veiculo.getTelefone()!=null)labelTelefone.setText(veiculo.getTelefoneFormatado());
        if(veiculo.getRua()!=null)labelRua.setText(veiculo.getRua());
        if(veiculo.getEmail()!=null)labelEmail.setText(veiculo.getEmail());
        if(veiculo.getNumero()!=null)labelNumero.setText(veiculo.getNumero());
        if(veiculo.getCEP()!=null)labelCEP.setText(veiculo.getCEPFormatado());
        if(veiculo.getComplemento()!=null)labelComplemento.setText(veiculo.getComplemento());
        if(veiculo.getDataDeNascimento()!=null)
            labelDataDeNascimento.setText(veiculo.getDataDeNascimento().toString());

        if(veiculo.getHabilitacao()!=null){
            labelNumeroDeRegistro.setText(habilitacao.getNumeroDeRegistro());
            labelCategoria.setText(habilitacao.getCategoria());
            if(habilitacao.getDataDeEmissao()!=null)
                labelDataDeEmissao.setText(habilitacao.getDataDeEmissao().toString());
            if(habilitacao.getValidade()!=null)
                labelValidade.setText(habilitacao.getValidade().toString());
        }

    }
}
