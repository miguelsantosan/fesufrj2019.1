package com.company;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.Main.*;

public class Cliente {
    private String cpf; //CPF para identificar o cliente
    private String cpfFormatado; //CPF formatado com pontos e traco para facilitar a leitura do usuario
    private int idade;
    private boolean aptoADirigir; //Se estiver alcoolizado ou drogado, recebe false. Caso contrario permanece true
    private boolean contrato;
    private Habilitacao habilitacao; //Habilitacao com seus dados
    private Apolice apolice; //Apolice de seguro
    private CartaoDeCredito cartao; //Cartao de credito com seus dados
    private Carro carroAtual; //Carro alugado atualmente. Nao pode alugar outro enquanto for diferente de null
    //private Contrato contrato;
    private HashMap<Long,Long> motoristasAutorizados; //Mapa contendo os CPF's dos motoristas autorizados pelo cliente


    int randomNum = ThreadLocalRandom.current().nextInt(IDADE_MINIMA, IDADE_MAXIMA + 1);

    public Cliente() {
        //Idade gerada aleatoriamente para dar diversidade e nao precisar gerar idades manualmente
        this.idade = randomNum;

        //CPF gerado usando o relogio do sistema, para garantir que seja unico
        long id = System.currentTimeMillis() % ID_LIMITE;
        if (id <= ID_RECENTE){
            id = (ID_RECENTE + 1) % ID_LIMITE;
        }
        this.cpf = Long.toString(id);
        ID_RECENTE = id;

        Formatter formatadorDeCpf = new CPFFormatter();
        String cpfNaoFormatado = this.cpf;
        this.cpfFormatado = formatadorDeCpf.format(cpfNaoFormatado);

        this.aptoADirigir = true; //Se o cliente e cadastrado, assume-se que possa dirigir. Logo, inicializa true
    }

    //=====DADOS DO CLIENTE - INICIO =====

    public int getIdade() {
        return this.idade;
    }
    //CPF do cliente, essa e a string que sera usada para identificar o cliente
    public String getCpf() {
        return this.cpf;
    }
    //Imprime CPF formatado, com pontos e hifen, para ficar mais legivel ao usuario
    public String getCpfFormatado() {
        return this.cpfFormatado;
    }

    public int getHabilitacaoID() {
        return this.habilitacao.id;
    }

    public boolean getHabilitacaoValidez() {
        return this.habilitacao.validez;
    }

    public void inverteAptidaoParaDirigir(){
        this.aptoADirigir = !this.aptoADirigir;
    }
    //=====DADOS DO CLIENTE - FIM =====

    //=====CARRO DO CLIENTE - INICIO =====
    public void alugarCarro(Carro carroAlugado) {
        if (carroAtual == null) {
            this.carroAtual = carroAlugado;
        }
        else{
            System.out.printf("O cliente %s já possui um carro alugado.\n",this.cpfFormatado);
        }
    }

    public void retornarCarro(){
        if (carroAtual == null){
            System.out.printf("O cliente %s não possui um carro alugado para devolver.\n", this.cpfFormatado);
        }
        else {
            carroAtual.setDisponivelParaAlugar(false);
            this.carroAtual = null;
        }
    }

    public Carro getCarroAtual() {
        return this.carroAtual;
    }

    public String getMarcaDoCarroAtual(){
        return this.carroAtual.getMarcaDoCarro();
    }

    public void dirigirCarroAlugado(int quilometros){
        if (this.carroAtual != null){
            System.out.printf("O cliente %s está dirigindo o carro %s.\n", this.cpfFormatado,this.carroAtual);
            this.carroAtual.aumentaQuilometragem(quilometros);
        }
        else {
            System.out.printf("O cliente %s não alugou um carro para dirigir.\n", this.cpfFormatado);
        }
    }
    //=====CARRO DO CLIENTE - FIM =====

    public boolean isContrato() {
        return contrato;
    }

    public void assinarContrato() {
        this.contrato = true;
    }
}
