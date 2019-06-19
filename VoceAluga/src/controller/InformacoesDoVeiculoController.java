package controller;


import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import controller.ScenesManager;
import model.Veiculo;
import model.dao.CadastroVeiculo;

public class InformacoesDoVeiculoController {

    ScenesManager manager = new ScenesManager();

    @FXML
    public Label labelFilial;

    @FXML
    public Label labelMarca;

    @FXML
    public Label labelModelo;

    @FXML
    public Label labelAno;

    @FXML
    public Label labelQuilometragem;

    @FXML
    public Label labelPlaca;

    @FXML
    public Label labelClasse;

    @FXML
    public Label labelChassi;

    @FXML
    public Label labelRENAVAM;

    @FXML
    public Label labelInformacoesAdicionais;

    @FXML
    public void processarBotaoVoltar(MouseEvent e) throws IOException {
        manager.mostrarTelaPrincipal();
    }

    @FXML
    public void processarBotaoEditar(MouseEvent e) throws IOException {
        manager.mostrarTelaCadastroDeVeiculo();
    }

    @FXML
    void processarBotaoDeletar(MouseEvent event) {

    }

    public void initialize() {
        Veiculo veiculo = CadastroVeiculo.getVeiculoAtual();

        preencherLabelsComDadosDoVeiculo(veiculo);
    }

    public void preencherLabelsComDadosDoVeiculo(Veiculo veiculo) {

        if(veiculo.getFilial()!=null)labelFilial.setText(veiculo.getFilial());
        if(veiculo.getChassi()!=null)labelChassi.setText(veiculo.getChassi());

        if(veiculo.getRENAVAM()!=null)labelRENAVAM.setText(veiculo.getRENAVAM());
        if(veiculo.getPlaca()!=null)labelPlaca.setText(veiculo.getPlaca());
        if(veiculo.getClasse()!=null)labelClasse.setText(veiculo.getClasse());
        if(veiculo.getMarca()!=null)labelMarca.setText(veiculo.getMarca());
        if(veiculo.getModelo()!=null)labelModelo.setText(veiculo.getModelo());
        if(veiculo.getAnoDeFabricacao()!=null)labelAno.setText(String.valueOf(veiculo.getAnoDeFabricacao()));
        if(veiculo.getQuilometragem()!=null)labelQuilometragem.setText(String.valueOf(veiculo.getQuilometragem()));
        if(veiculo.getInformacoesAdicionais()!=null)labelInformacoesAdicionais.setText(veiculo.getInformacoesAdicionais());
    }
}
