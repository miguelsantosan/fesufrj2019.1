package com.company;

public class Main {
    public static final int IDADE_MINIMA = 25;
    public static final int IDADE_MAXIMA = 75;

    public static final long ID_LIMITE = 100000000000L;
    public static long ID_RECENTE = 0;

    public static final int NUMERO_CLIENTES = 1;

    //Array global com as marcas de carro
    public static final String[] marcasDeCarro = new String[]{
            "AUDI",
            "BMW",
            "CHEVROLET",
            "CITROEN",
            "FERRARI",
            "FIAT",
            "FORD",
            "HONDA",
            "KIA",
            "MERCEDES",
            "MITSUBISHI",
            "NISSAN",
            "PEUGEOT",
            "RENAULT",
            "TOYOTA",
            "VOLKSWAGEN"};

    public static void main(String[] args) {
        Cliente clientes[] = new Cliente[NUMERO_CLIENTES];
        Carro myCarro = new Carro("Fiat");

        for(int i = 0; i < NUMERO_CLIENTES; i++){
            clientes[i] = new Cliente();
            System.out.println("Idade:");
            System.out.printf("%d\n", clientes[i].getIdade());
            System.out.println("CPF:");
            //System.out.printf("%s\n", clientes[i].getCpf());
            clientes[i].printCpfFormatado();
            System.out.println("========");
            System.out.println("Carro atual:");
            System.out.printf("%S\n", clientes[i].getCarroAtual());
            System.out.println("========");
            clientes[i].alugarCarro(myCarro);
            System.out.println("Aluguei o carro:");
            System.out.println("Marca do carro atual:");
            System.out.printf("%s\n",clientes[i].getCarroAtual().getMarcaDoCarro());
            System.out.println("========");
            String t = clientes[i].getCarroAtual().getMarcaDoCarro();
            //Marca m = clientes[i].getCarroAtual().getMarcaDoCarro();
//            if(m != Marca.MERCEDES){
//                System.out.println("Não é Mercedez");
//            }

            if(t != "Toyota"){
                System.out.println("Não é Toyota");
                System.out.printf("É um %s\n",clientes[i].getCarroAtual().getMarcaDoCarro());
            }
        }

    }
}
