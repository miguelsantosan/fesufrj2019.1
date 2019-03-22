package com.company;

public class Main {
    public static final int IDADE_MINIMA = 25;
    public static final int IDADE_MAXIMA = 75;

    public static final long ID_LIMITE = 100000000000L;
    public static long ID_RECENTE = 0;

    public static final int NUMERO_CLIENTES = 1;

    public static void main(String[] args) {
        Cliente clientes[] = new Cliente[NUMERO_CLIENTES];


        for(int i = 0; i < NUMERO_CLIENTES; i++){
            clientes[i] = new Cliente();
            System.out.printf("%d\n", clientes[i].getIdade());
            System.out.printf("%s\n", clientes[i].getCpf());
            clientes[i].printCpfFormatado();
            System.out.printf("%S\n", clientes[i].carroAtual);
        }

    }
}
