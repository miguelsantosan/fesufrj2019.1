package com.company;

public class Carro {
    private Marca marca;

    public Carro(Marca marcaDoCarro){
        this.marca = marcaDoCarro;
    }

    public Marca getMarcaDoCarro() {
        return this.marca;
    }

    public String getNomeDaMarcaDoCarro() {
        return this.marca.nome;
    }

}
