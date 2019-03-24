package com.company;

public class Main {
    static final int IDADE_MINIMA = 25;
    static final int IDADE_MAXIMA = 75;

    static final long ID_LIMITE = 100000000000L;
    static long ID_RECENTE = 0;

    static final int NUMERO_CLIENTES = 1;

    //Array global com as marcas de carro
    public static final String[] VETOR_MARCAS_DE_CARRO = new String[]{
            "AUDI","BMW","CHEVROLET","CITROEN","FERRARI","FIAT","FORD","HONDA",
            "KIA","MERCEDES","MITSUBISHI","NISSAN","PEUGEOT","RENAULT","TOYOTA","VOLKSWAGEN"};

    private static final String[] VETOR_PAISES = {
            "ÁFRICA DO SUL","ALEMANHA","ARGENTINA","AUSTRÁLIA","BÉLGICA","BOLÍVIA","BRASIL",
            "BULGÁRIA","CANADÁ","CHILE","CHINA","COLÔMBIA","ESPANHA","ESTADOS UNIDOS",
            "FRANÇA","ÍNDIA","JAPÃO","MARROCOS","MÉXICO","PORTUGAL","RÚSSIA"};

    public static void main(String[] args) {
        Cliente clientes[] = new Cliente[NUMERO_CLIENTES];
        Carro myCarro = new Carro("Fiat");

        for(int i = 0; i < NUMERO_CLIENTES; i++){
            clientes[i] = new Cliente();
            System.out.printf("Idade: %d\n", clientes[i].getIdade());
            //System.out.printf("CPF: %s\n", clientes[i].getCpf());
            clientes[i].dirigirCarroAlugado(1);
            System.out.printf("CPF: %s\n",clientes[i].getCpfFormatado());
            System.out.printf("Carro atual: %s\n", clientes[i].getCarroAtual());
            clientes[i].alugarCarro(myCarro);
            System.out.println("Aluguei o carro");
            System.out.printf("Marca do carro atual: %s\n",clientes[i].getCarroAtual().getMarcaDoCarro());
            String t = clientes[i].getCarroAtual().getMarcaDoCarro();
            clientes[i].dirigirCarroAlugado(1);
            if(!t.equals("TOYOTA")){
                System.out.println("Não é Toyota");
                System.out.printf("É um %s\n",clientes[i].getCarroAtual().getMarcaDoCarro());
            }
            System.out.println("Vou devolver o carro:");
            clientes[i].retornarCarro();
            System.out.printf("Carro atual: %s\n", clientes[i].getCarroAtual());
            System.out.println("Devolvi o carro:");
        }

    }
}
