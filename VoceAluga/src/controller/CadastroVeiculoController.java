package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Veiculo;
import model.dao.CadastroVeiculo;

import java.io.IOException;
import java.util.TreeMap;

public class CadastroVeiculoController {

    ScenesManager manager = new ScenesManager();

    @FXML
    TextField campoFilial;

    @FXML
    TextField campoMarca;

    @FXML
    TextField campoAno;

    @FXML
    TextField campoChassi;

    @FXML
    TextField campoRENAVAM;

    @FXML
    TextField campoClasse;

    @FXML
    TextField campoPlaca;

    @FXML
    TextField campoModelo;

    @FXML
    TextField campoQuilometragem;

    @FXML
    TextField campoInformacoesAdicionais;

    @FXML
    Button BotaoCancelar;

    @FXML
    Button BotaoConfirmar;


    public void initialize() {
        if(CadastroVeiculo.getVeiculoAtual()!=null){
            Veiculo veiculo = CadastroVeiculo.getVeiculoAtual();
            preencherCamposComDadosDoVeiculo(veiculo);
            campoChassi.setDisable(true);
        }
    }

    @FXML
    void processarBotaoCancelar(MouseEvent event) throws IOException{
        manager.mostrarTelaPrincipal();
    }

    @FXML
    void processarBotaoConfirmar(MouseEvent e) throws IOException{
        if(CadastroVeiculo.getVeiculoAtual()==null){
            System.out.println("Cadastrando veiculo");
            adicionarVeiculo();
        }else{
            System.out.println("alterando veiculo");
            alterarVeiculo();
        }
    }

    TreeMap<String,String> gerarMapAPartirDoFormularioVeiculo(){
        TreeMap<String,String> campos = new TreeMap<>();

        if(!campoChassi.equals("")) campos.put("chassi", campoChassi.getText());
        if(!campoRENAVAM.equals("")) campos.put("RENAVAM", campoRENAVAM.getText());
        if(campoFilial.getText() != null) campos.put("filail", campoFilial.getText());
        if(campoPlaca.getText() != null) campos.put("placa", campoPlaca.getText());
        if(campoMarca.getText() != null) campos.put("marca", campoMarca.getText());
        if(campoModelo.getText()!=null) campos.put("modelo", campoModelo.getText());
        if(campoAno.getText() != null) campos.put("ano", campoAno.getText());
        if(campoQuilometragem.getText() !=null) campos.put("quilometragem", campoQuilometragem.getText());
        if(campoInformacoesAdicionais.getText() != null) campos.put("informacoes adicionais", campoInformacoesAdicionais.getText());

        return campos;
    }
    //Correto?
    @FXML
    void adicionarVeiculo() throws IOException{
        if(campoChassi.getText().equals("") ){
            mostrarErroDeCadastro("Preencha o Chassi");
            return;
        }

        if(!campoChassi.getText().equals("") && CadastroVeiculo.buscarPorChassi(campoChassi.getText())){
            mostrarErroDeCadastro("CPF já cadastrado");
            return;
        }

        if(validarCampos() == false) return;

        TreeMap<String,String> camposVeiculo = gerarMapAPartirDoFormularioVeiculo();
        //Correto?
        if(CadastroVeiculo.cadastrarVeiculo(camposVeiculo)){
            mostrarMensagemDeSucesso("Veiculo cadastrado com sucesso");
            manager.mostrarTelaPrincipal();
        }
        else{
            mostrarErroDeCadastro("Não foi possível cadastrar o veiculo");
        }

    }
    //Correto?
    @FXML
    void alterarVeiculo(){
        if(validarCampos() == false) return;


        TreeMap<String,String> camposVeiculo = gerarMapAPartirDoFormularioVeiculo();

        //Correto?
        if(CadastroVeiculo.alterarVeiculo(camposVeiculo)){
            mostrarMensagemDeSucesso("Cadastro alterado com sucesso");
            manager.mostrarTelaPrincipal();
        }
        else{
            mostrarErroDeCadastro("Não foi possível alterar o cadastro do veiculo");
        }
    }
    //ToDo?
    boolean validarCampos(){

        if(campoFilial.getText()== null || campoChassi.getText()== null || campoPlaca.getText().equals("")
                || campoMarca.getText() == null || campoModelo.getText() == null || campoAno.getText()== null
                || campoQuilometragem.getText() == null || campoClasse == null){
            mostrarErroDeCadastro("Preencha todos os campos obrigatórios");
            return false;
        }
        if(campoChassi.getText() == ""){
            return false;
        }
        //ToDo?
        if(!Veiculo.ValidarChassi(campoChassi.getText())){
            mostrarErroDeCadastro("Chassi inválido");
            return false;
        }

        return true;
    }

    public void mostrarMensagemDeSucesso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro bem sucedido");
        alert.setHeaderText(mensagem);
        alert.setContentText("");
        alert.showAndWait();
    }

    public void mostrarErroDeCadastro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no Cadastro");
        alert.setHeaderText("");
        alert.setContentText( mensagem);
        alert.showAndWait();
    }

    public void preencherCamposComDadosDoVeiculo(Veiculo veiculo){
        campoFilial.setText(veiculo.getFilial());
        campoMarca.setText(veiculo.getMarca());
        campoAno.setText(String.valueOf(veiculo.getAnoDeFabricacao()));
        campoChassi.setText(veiculo.getChassi());
        campoRENAVAM.setText(veiculo.getRENAVAM());
        campoClasse.setText(String.valueOf(veiculo.getClasse()));
        campoPlaca.setText(veiculo.getPlaca());
        campoModelo.setText(veiculo.getModelo());
        campoFilial.setText(veiculo.getFilial());
        campoInformacoesAdicionais.setText(veiculo.getInformacoesAdicionais());
    }
}