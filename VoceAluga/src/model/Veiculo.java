package model;

public class Veiculo {
	private String filial;
	private String placa;
	private String chassi;
	private String marca;
	private char classe;
	private int anoDeFabricacao;
	private int tempoEmAnos;
	private float quilometragem;
	private boolean precisaManutencao;
	/**
	 * Construtor.
	 * @param chassi 		o Numero de Identificacao (Chassi) do Veiculo
	 * @param marca 		a marca do veiculo
	 * @param placa 		a placa do veiculo
	 * @param quilometragem a quilometragem do veiculo
	 */
	public Veiculo(String chassi, String marca, String placa, float quilometragem){
		this.chassi = chassi;
		this.marca = marca;
		this.placa = placa;
		this.quilometragem = quilometragem;
		this.precisaManutencao = false;
	}
	/**
	 * @return a filial atual do veiculo
	 */
	public String getFilial() {
		return this.filial;
	}
	/**
	 * @return a placa do veiculo
	 */
	public String getPlaca() {
		return this.placa;
	}
	/**
	 * @return o chassi do veiculo
	 */
	public String getChassi() {
		return this.chassi;
	}
	/**
	 * @return a marca do veiculo
	 */
	public String getMarca() {
		return this.marca;
	}
	/**
	 * @return a classe do veiculo
	 */
	public char getClasse() {
		return this.classe;
	}
	/**
	 * @return o ano de fabricacao do veiculo
	 */
	public int getAnoDeFabricacao() {
		return this.anoDeFabricacao;
	}	
	/**
	 * @return o tempo em anos do veiculo
	 */
	public int getTempoEmAnos() {
		return tempoEmAnos;
	}
	/**
	 * @return a quilometragem do veiculo
	 */
	public float getQuilometragem() {
		return quilometragem;
	}
	/**
	 * @return verdadeiro se o veiculo precisa de manutencao, falso caso contrario
	 */
	public boolean isPrecisaManutencao() {
		return precisaManutencao;
	}
	/**
	 * @param precisaManutencao booleano que indica se o veiculo precisa de manutencao ou nao
	 */
	public void setPrecisaManutencao(boolean precisaManutencao) {
		this.precisaManutencao = precisaManutencao;
	}

	
}
