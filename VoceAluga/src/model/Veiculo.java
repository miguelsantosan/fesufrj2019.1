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
	private String classe;
	private String cor;
	private String manutencaoEmDia;
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
				   String modelo, Integer ano, Integer quilometragem, String classe, String cor, String manutencaoEmDia,
				   String informacoesAdicionais){
		this.filial = filial;
		this.chassi = chassi;
		this.RENAVAM = RENAVAM;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoDeFabricacao = ano;
		this.quilometragem = quilometragem;
		this.classe = classe;
		this.cor = cor;
		this.manutencaoEmDia = manutencaoEmDia;
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
	}
	//CONSTRUTOR TESTE
	//================

	public Veiculo(){

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
		return this.classe;
	}
	/**
	 * @param classe a classe do veiculo na locadora
	 */
	public void setClasse(String classe) {
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
	 * @param quilometragem a quilometragem do veiculo atual
	 */
	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}
	/**
	 * @return a cor do veiculo
	 */
	public String getCor() {
		return cor;
	}
	/**
	 * @param cor a cor do veiculo
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	/**
	 * @return se a manutencao do veiculo esta em dia, retorna String "SIM" ou "NÂO"
	 */
	public String getManutencaoEmDia() {
		return manutencaoEmDia;
	}
	/**
	 * @param manutencaoEmDia String que indica se a manutencao do veiculo esta em dia ou nao
	 */
	public void setManutencaoEmDia(String manutencaoEmDia) {
		this.manutencaoEmDia = manutencaoEmDia;
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
	public static boolean ValidarChassi(String chassi) {

		//https://respostas.guj.com.br/41944-validar-chassi-chassi-sempre-invalido

		if (chassi.length() != 17)
		{
			return false;
		}

//		Pattern zeroNoPrimeiroDigito = Pattern.compile ("^0");
//		Matcher matcherZero  = zeroNoPrimeiroDigito.matcher(chassi);
//
//		Pattern espacoNoChassi = Pattern.compile (" ");
//		Matcher matcherEspaco = espacoNoChassi.matcher(chassi);
//
//		Pattern repeticaoMaisDe6Vezes = Pattern.compile ("^.{4,}([0-9A-Z])\\1{5,}");
//		Matcher matcherRepetir = repeticaoMaisDe6Vezes.matcher(chassi);
//
//		Pattern caracteresiIoOqQ = Pattern.compile ("[iIoOqQ]");
//		Matcher matcherCaract = caracteresiIoOqQ.matcher(chassi);
//
//		Pattern ultimos6Numericos = Pattern.compile ("[0-9]{6}$");
//		Matcher matcherUltimos = ultimos6Numericos.matcher(chassi);
//
//		if (matcherZero.find() || matcherEspaco.find() || matcherRepetir.find() || matcherCaract.find() || matcherUltimos.find())
//		{
//			return false;
//		}

		return true;
	}

}
