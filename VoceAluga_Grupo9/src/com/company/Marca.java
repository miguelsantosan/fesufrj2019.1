package com.company;

public enum Marca {
    AUDI("Audi"),
    BMW("BMW"),
    CHEVROLET("Chevrolet"),
    CITROEN("Citroen"),
    FERRARI("Ferrari"),
    FIAT("Fiat"),
    FORD("Ford"),
    HONDA("Honda"),
    KIA("Kia"),
    MERCEDES("Mercedes-Benz"),
    MITSUBISHI("Mitsubishi"),
    NISSAN("Nissan"),
    PEUGEOT("Peugeot"),
    RENAULT("Renault"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("Volkswagen");

    public final String nome;

    Marca(String nomeMarca){
        this.nome = nomeMarca;
    }
}
