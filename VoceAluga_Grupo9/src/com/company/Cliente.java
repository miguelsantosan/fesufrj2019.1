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
    private Habilitacao habilitacao; //Habilitacao com seus dados
    private Apolice apolice; //Apolice de seguro
    private CartaoDeCredito cartao; //Cartao de credito com seus dados
    private HashMap<Long,Long> motoristasAutorizados; //Mapa contendo os CPF's dos motoristas autorizados pelo cliente
    public Carro carroAtual; //Carro alugado atualmente. Nao pode alugar outro enquanto for diferente de null

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
        this.aptoADirigir = true; //Se o cliente e cadastrado, assume-se que possa dirigir. Logo, inicializa true
    }

    public int getIdade() {
        return this.idade;
    }

    public String getCpf() {
        return this.cpf;
    }


    public void printCpfFormatado() {
        if (this.cpfFormatado == null) {
            Formatter formatadorDeCpf = new CPFFormatter();
            String cpfNaoFormatado = this.cpf;
            this.cpfFormatado = formatadorDeCpf.format(cpfNaoFormatado);
        }
        System.out.printf("%s\n",this.cpfFormatado);
    }

    /*
    public void printCpfFormatado(){ //Teste de imprimir o CPF formatado usando MaskFormatter e JFormattedTextField
        try {
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            this.cpfFormatado = new JFormattedTextField(mascaraCpf);
            //mascaraCpf.getDisplayValue(cpfFormatado);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.printf("%s\n", this.cpfFormatado);
    }
    */

    public int getHabilitacaoID() {
        return this.habilitacao.id;
    }

    public boolean getHabilitacaoValidez() {
        return this.habilitacao.validez;
    }

    public void inverteAptidaoParaDirigir(){
        this.aptoADirigir = !this.aptoADirigir;
    }
}
