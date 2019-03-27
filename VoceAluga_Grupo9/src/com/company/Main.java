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
        Cliente cliente = new Cliente();
        Carro myCarro = new Carro("Fiat");

        for (String pais : VETOR_PAISES){
            apolicesPorPais.put(pais,new LinkedHashSet<Enum>());
        }

        fazTestesComCliente(cliente, myCarro);

        fazTesteComMapaDeApolices(apolicesPorPais);
    }

    public static void fazTestesComCliente(Cliente cliente, Carro carro){
        System.out.printf("Idade: %d\n", cliente.getIdade()); //Pego a idade
        System.out.printf("CPF: %s\n",cliente.getCpfFormatado()); //Pego o CPF formatado

        System.out.printf("Carro atual: %s\n", cliente.getCarroAtual()); //Pego o carro atual
        cliente.dirigirCarroAlugado(1); //Tenta dirigir sem ter alugado um carro
        cliente.alugarCarro(carro); //Aluguei o carro
        System.out.println("Aluguei o carro");
        System.out.printf("Marca do carro atual: %s\n",cliente.getMarcaDoCarroAtual());
        cliente.dirigirCarroAlugado(1); //Dirigi o carro

        String marcaDoCarroDoCliente = cliente.getMarcaDoCarroAtual();
        Enum marcaErrada = MarcaDeCarro.TOYOTA;
        if(!marcaDoCarroDoCliente.equals(marcaErrada)){
            System.out.printf("Não é %s\n", marcaErrada);
            System.out.printf("É um %s\n",cliente.getMarcaDoCarroAtual());
        }
        System.out.println("Vou devolver o carro:");
        cliente.retornarCarro();
        System.out.printf("Carro atual: %s\n", cliente.getCarroAtual());
        System.out.println("Devolvi o carro");
    }

    public static void fazTesteComMapaDeApolices(LinkedHashMap<String,LinkedHashSet<Enum>> mapa){
        System.out.println("Vou colocar apólices no mapa.");
        insereApolicesPorPaisNoMapa(mapa);
        System.out.println("Coloquei apólices no mapa.");

        System.out.println("Vou imprimir as apólices do mapa.");
        System.out.println("=====APÓLICES=====");
        imprimeApolicesDosPaises(mapa);
        System.out.println("==================");
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
