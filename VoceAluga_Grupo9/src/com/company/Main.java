package com.company;


import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static final int IDADE_MINIMA = 25;
    static final int IDADE_MAXIMA = 75;

    static final long ID_LIMITE = 100000000000L;
    static long ID_RECENTE = 0;

    static final int NUMERO_CLIENTES = 1;

    public static final String[] VETOR_MARCAS_DE_CARRO = new String[]{
            "AUDI","BMW","CHEVROLET","CITROEN","FERRARI","FIAT","FORD","HONDA",
            "KIA","MERCEDES","MITSUBISHI","NISSAN","PEUGEOT","RENAULT","TOYOTA","VOLKSWAGEN"};

    public static final String[] VETOR_PAISES = {
            "ÁFRICA DO SUL","ALEMANHA","ARGENTINA","AUSTRÁLIA","BÉLGICA","BOLÍVIA","BRASIL",
            "BULGÁRIA","CANADÁ","CHILE","CHINA","COLÔMBIA","ESPANHA","ESTADOS UNIDOS",
            "FRANÇA","ÍNDIA","JAPÃO","MARROCOS","MÉXICO","PORTUGAL","RÚSSIA"};

    public static LinkedHashMap<String, LinkedHashSet<Enum>> apolicesPorPais = new LinkedHashMap<>();



    public static void main(String[] args) {
        Cliente clientes[] = new Cliente[NUMERO_CLIENTES];
        Carro myCarro = new Carro("Fiat");

        for (String pais : VETOR_PAISES){
            apolicesPorPais.put(pais,new LinkedHashSet<Enum>());
        }

        for(int i = 0; i < NUMERO_CLIENTES; i++){
            clientes[i] = new Cliente(); //Criei o cliente
            System.out.printf("Idade: %d\n", clientes[i].getIdade()); //Pego a idade
            System.out.printf("CPF: %s\n",clientes[i].getCpfFormatado()); //Pego o CPF formatado

            System.out.printf("Carro atual: %s\n", clientes[i].getCarroAtual()); //Pego o carro atual
            clientes[i].dirigirCarroAlugado(1); //Tenta dirigir sem ter alugado um carro
            clientes[i].alugarCarro(myCarro); //Aluguei o carro
            System.out.println("Aluguei o carro");
            System.out.printf("Marca do carro atual: %s\n",clientes[i].getMarcaDoCarroAtual());
            clientes[i].dirigirCarroAlugado(1); //Dirigi o carro

            String marcaDoCarroDoCliente = clientes[i].getMarcaDoCarroAtual();
            Enum marcaErrada = MarcaDeCarro.TOYOTA;
            if(!marcaDoCarroDoCliente.equals(marcaErrada)){
                System.out.printf("Não é %s\n", marcaErrada);
                System.out.printf("É um %s\n",clientes[i].getMarcaDoCarroAtual());
            }
            System.out.println("Vou devolver o carro:");
            clientes[i].retornarCarro();
            System.out.printf("Carro atual: %s\n", clientes[i].getCarroAtual());
            System.out.println("Devolvi o carro");
        }

        System.out.println("Vou colocar apólices no mapa.");
        insereApolicesPorPaisNoMapa(apolicesPorPais);
        System.out.println("Coloquei apólices no mapa.");

        System.out.println("Vou imprimir as apólices do mapa.");
        System.out.println("=====APÓLICES=====");
        imprimeApolicesDosPaises(apolicesPorPais);
        System.out.println("==================");

//        for (String pais : apolicesPorPais.keySet()){
//            System.out.println(pais + ": " + apolicesPorPais.get(pais));
//        }

    }

    public static void insereApolicesPorPaisNoMapa(LinkedHashMap<String, LinkedHashSet<Enum>> mapaDeApolices){
        //Quero gerar um numero aleatorio de 0 a 3, se for 0 insiro o pais no Mapa
        final int APOLICE_RANGE = 3;
        //int condicaoParaInserir = ThreadLocalRandom.current().nextInt(0,  APOLICE_RANGE + 1);

        for (String pais : mapaDeApolices.keySet()){
            do {
                for (Apolice apolice : Apolice.values()){
                    int condicaoParaInserir = ThreadLocalRandom.current().nextInt(0, APOLICE_RANGE + 1);
                    if (condicaoParaInserir == 0) {
                        mapaDeApolices.get(pais).add(apolice);
                    }
                }
            }while (mapaDeApolices.get(pais).isEmpty());
        }
    }

    public static void imprimeApolicesDosPaises(LinkedHashMap<String, LinkedHashSet<Enum>> mapaDeApolices){
        for (String pais : mapaDeApolices.keySet()){
            System.out.println(pais + ": " + mapaDeApolices.get(pais));
        }
    }
}
