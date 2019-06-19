package model;

public class Veiculo {
	private Long id;
	private String filial;
	private String chassi;
	private String RENAVAM;
	private String placa;
	private String marca;
	private String modelo;
	private Integer anoDeFabricacao;
	private Integer quilometragem;
	private char classe;
	private boolean precisaManutencao;
	private String informacoesAdicionais;
	/**
	 * Construtor.
	 * @param marca 		a marca do veiculo
	 * @param modelo		o modelo do veiculo
	 * @param placa 		a placa do veiculo
	 * @param chassi 		o Numero de Identificacao (Chassi) do Veiculo
	 * @param quilometragem a quilometragem do veiculo
	 */
	public Veiculo(String filial, String chassi, String RENAVAM, String placa, String marca,
				   String modelo, Integer ano, Integer quilometragem, String informacoesAdicionais){
		this.filial = filial;
		this.chassi = chassi;
		this.RENAVAM = RENAVAM;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoDeFabricacao = ano;
		this.quilometragem = quilometragem;
		this.precisaManutencao = false;
		this.informacoesAdicionais = informacoesAdicionais;
	}
	
	//================
	//CONSTRUTOR TESTE
	public Veiculo(Long id, String marca, String modelo, String placa, String chassi, Integer quilometragem){
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.chassi = chassi;
		this.quilometragem = quilometragem;
		this.precisaManutencao = false;
	}
	//CONSTRUTOR TESTE
	//================

	public Veiculo(){
		this.precisaManutencao = false;
	}
	/**
	 * @return o ID do veiculo
	 */
	public Long getID() {
		return this.id;
	}
	/**
	 * @return a filial atual do veiculo
	 */
	public String getFilial() {
		return this.filial;
	}
	/**
	 * @param filial a filial onde o veiculo esta atualmente
	 */
	public void setFilial(String filial) {
		this.filial = filial;
	}
	/**
	 * @return a marca do veiculo
	 */
	public String getMarca() {
		return this.marca;
	}
	/**
	 * @param marca a marca do veiculo
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return o modelo do veiculo
	 */
	public String getModelo() {
		return this.modelo;
	}
	/**
	 * @param modelo o modelo do veiculo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return a placa do veiculo
	 */
	public String getPlaca() {
		return this.placa;
	}
	/**
	 * @param placa a placa do veiculo
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return o chassi do veiculo
	 */
	public String getChassi() {
		return this.chassi;
	}
	/**
	 * @param chassi o numero do chassi do carro
	 */
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	/**
	 * @return o RENAVAM do veiculo
	 */
	public String getRENAVAM() {
		return RENAVAM;
	}
	/**
	 * @param RENAVAM o RENAVAM do veiculo
	 */
	public void setRENAVAM(String RENAVAM) {
		this.RENAVAM = RENAVAM;
	}
	/**
	 * @return a classe do veiculo
	 */
	public String getClasse() {
		return String.valueOf(this.classe);
	}
	/**
	 * @param classe a classe do veiculo na locadora
	 */
	public void setClasse(char classe) {
		this.classe = classe;
	}
	/**
	 * @return o ano de fabricacao do veiculo
	 */
	public Integer getAnoDeFabricacao() {
		return this.anoDeFabricacao;
	}
	/**
	 * @param ano o ano em que o veiculo foi fabricado
	 */
	public void setAnoDeFabricacao(Integer ano) {
		this.anoDeFabricacao = ano;
	}
	/**
	 * @return a quilometragem do veiculo
	 */
	public Integer getQuilometragem() {
		return quilometragem;
	}
	/**
	 * @param quilometragem a quilometragem do veiculo atual do veiculo
	 */
	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
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
	/**
	 * @return as informacoes adicionais do veiculo
	 */
	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}
	/**
	 * @param informacoesAdicionais informacoes adicionais que o veiculo pode possuir
	 */
	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	public static boolean ValidarChassi(String text) {
		// TODO Auto-generated method stub
		return false;
	}

}
