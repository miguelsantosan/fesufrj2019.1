package model;
import java.time.LocalDate;
import model.Habilitacao;

public class Cliente {
  private String nome;
  private String cpf; 
  private String passaporte;
  private String email;
  private LocalDate dataDeNascimento;
  private Habilitacao habilitacao; 
  
  private String telefone;
  
  
  private String CEP;
  private String pais;
  private String estado;
  private String cidade;
  private String bairro;
  private String rua;
  private String numero;
  private String complemento;
  


  public Cliente(String nome, String cpf) {
      this.nome = nome;
      this.cpf = cpf;
      this.habilitacao= new Habilitacao();
  }
  
  public Cliente() {
	  this.habilitacao= new Habilitacao();
  }

  // ====getters====
  public String getNome() {
      return this.nome;
  }

  public LocalDate getDataDeNascimento() {
      return this.dataDeNascimento;
  }
 
  public String getCPF() {
      return this.cpf;
  }
  
  public String getCPFFormatado(){
	  	String CPFFormatado = null;
	  try{
		  CPFFormatado = this.cpf.substring(0,3) +"." + this.cpf.substring(3,6)+ "."
				  		+this.cpf.substring(6,9)+ "-" + this.cpf.substring(9,11);	
	  }catch(IndexOutOfBoundsException e){
		  System.err.println("Cliente.getCPFFormatado");
		  System.err.println(e.getMessage());
	  }
	  return CPFFormatado;
  }
  
  
  public String getCEPFormatado(){
		String CEPFormatado = null;
		  try{
			  CEPFormatado = this.CEP.substring(0,5) + "-" + this.CEP.substring(5);	
		  }catch(IndexOutOfBoundsException e){
			  System.err.println("Cliente.getCEPFormatado");
			  System.err.println(e.getMessage());
		  }
		  return CEPFormatado;
  }
  
  public String getTelefoneFormatado(){
		String telefoneFormatado = null;
		  try{
			  telefoneFormatado = "+" + this.telefone.substring(0,2) + " (" +this.telefone.substring(2, 4)+ ") " 
					  				  + this.telefone.substring(4);	
		  }catch(IndexOutOfBoundsException e){
			  System.err.println("Cliente.getCEPFormatado");
			  System.err.println(e.getMessage());
		  }
		  return telefoneFormatado;
}
  
 

  
  public String getPassaporte() {
	  return this.passaporte;
  }
  
  public String getCEP() {
	  return this.CEP;
  }
  
  public String getEmail() {
	  return this.email;
  }
  
  public Habilitacao getHabilitacao() {
	  return this.habilitacao;
  }
  
  public String getPais() {
	  return this.pais;
  }
  
  public String getCidade() {
	  return this.cidade;
  }
  
  public String getEstado() {
	  return this.estado;
  }
  
  public String getBairro() {
	  return this.bairro;
  }
  
  public String getRua() {
	  return this.rua;
  }
  
  public String getNumero() {
	  return this.numero;
  }
  
  public String getComplemento() {
	  return this.complemento;
  }
  
  public String getTelefone() {
	  return this.telefone;
  }
  
  //====setters====
  public void setNome(String nome) {
      this.nome = nome;
  }

  public void setDataDeNascimento(LocalDate data) {
      this.dataDeNascimento = data;
  }
 
  public void setCpf(String cpf) {
      this.cpf = cpf;
  }
  
  public void setPassaporte(String passaporte) {
	  this.passaporte = passaporte;
  }
  
  public void setCEP(String CEP) {
	  this.CEP = CEP;
  }
  
  public void setEmail(String email) {
	  this.email = email;
  }
  
  public void setHabilitacao(String numeroDeRegistro,String categoria, LocalDate validade, LocalDate dataDeEmissao) {
	  this.habilitacao = new Habilitacao(numeroDeRegistro,categoria,validade,dataDeEmissao); 
  }
  
  public void setTelefone(String telefone) {
	  this.telefone = telefone;
  }

  
//  =====================
  
  
  
}