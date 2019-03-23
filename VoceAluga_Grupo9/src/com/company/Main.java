package com.company;

public class Main {
    public static final int IDADE_MINIMA = 25;
    public static final int IDADE_MAXIMA = 75;

    public static final long ID_LIMITE = 100000000000L;
    public static long ID_RECENTE = 0;

    public static final int NUMERO_CLIENTES = 1;

    public static void main(String[] args) {
        Cliente clientes[] = new Cliente[NUMERO_CLIENTES];
        Carro myCarro = new Carro(Marca.FIAT);

        for(int i = 0; i < NUMERO_CLIENTES; i++){
            clientes[i] = new Cliente();
            System.out.println("Idade:");
            System.out.printf("%d\n", clientes[i].getIdade());
            System.out.println("CPF:");
            //System.out.printf("%s\n", clientes[i].getCpf());
            clientes[i].printCpfFormatado();
            System.out.println("Carro atual:");
            System.out.printf("%S\n", clientes[i].getCarroAtual());
            clientes[i].alugarCarro(myCarro);
            System.out.println("Aluguei o carro:");
            //System.out.println("Imprimir marca do Carro atual:");
            //clientes[i].imprimirMarcaDoCarroAtual();
            System.out.println("Marca do carro atual:");
            System.out.printf("%s\n",clientes[i].getCarroAtual().getNomeDaMarcaDoCarro());
            System.out.println("========");
            String t = clientes[i].getCarroAtual().getNomeDaMarcaDoCarro();
            Marca m = clientes[i].getCarroAtual().getMarcaDoCarro();
            if(m != Marca.MERCEDES){
                System.out.println("Não é Mercedez");
            }

            if(t != "Audi"){
                System.out.println("Nao e Audi");
                System.out.printf("É um %s\n",clientes[i].getCarroAtual().getMarcaDoCarro());
            }
        }

    }
}
