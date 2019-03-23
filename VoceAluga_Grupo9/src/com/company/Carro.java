package com.company;

public class Carro {
    private String marca;
    private int quilometragem;
    private boolean disponivel;

    public Carro(String marcaDoCarro){
        this.marca = marcaDoCarro;

    }

    public String getMarcaDoCarro() {
        return this.marca;
    }

    public int getQuilometragem() {
        return this.quilometragem;
    }

    public void aumentaQuilometragem(int quilometrosPercorridos){
        this.quilometragem += quilometrosPercorridos;
    }

    public boolean disponivelParaAlugar() {
        return disponivel;
    }

    public void setDisponivelParaAlugar(boolean disponivel) {
        this.disponivel = disponivel;
    }


}
