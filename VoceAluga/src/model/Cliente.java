package model;
import java.util.Date;

import model.versaoAnterior.Carro;
import model.versaoAnterior.Pais;

public class Cliente {
  private String nome;
  private String cpf; 
  private String passaporte;
  private String cpfFormatado;
  private String CEP;
  private String email;
  private Date dataDeNascimento;
  private Pais paisAtual;
  private boolean contrato;
//  private Habilitacao habilitacao; 
//  private Apolice apolice;
//  private CartaoDeCredito cartao; 
  private Carro carroAtual; 

  public Cliente(String nome, String cpf) {
      this.nome = nome;
      this.cpf = cpf;
  }
  
  public Cliente() {
	  
  }

  //=====DADOS DO CLIENTE  =====

  // ---getters---
  public String getNome() {
      return this.nome;
  }

  public Date getDataDeNascimento() {
      return this.dataDeNascimento;
  }
 
  public String getCpf() {
      return this.cpf;
  }
  //Imprime CPF formatado, com pontos e hifen, para ficar mais legivel ao usuario
  public String getCpfFormatado() {
      return this.cpfFormatado;
  }

  public Pais getPaisDoCliente(){
	  return this.paisAtual;
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
  
//  public int getHabilitacaoID() {
//      return this.habilitacao.id;
//  }
//
//  public boolean getHabilitacaoValidez() {
//      return this.habilitacao.validez;
//  }

  //---setters---
  public void setNome(String nome) {
      this.nome = nome;
  }

  public void setDataDeNascimento(Date data) {
      this.dataDeNascimento = data;
  }
 
  public void setCpf(String cpf) {
      this.cpf = cpf;
  }
  
  public void setPaisDoCliente(Pais pais){
	  this.paisAtual = pais;
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
  
  //=====CARRO DO CLIENTE =====
  
  public void alugarCarro(Carro carroAlugado) {
      if (carroAtual == null) {
          if (carroAlugado.disponivelParaAlugar()) {
              this.carroAtual = carroAlugado;
              carroAlugado.carroFoiAlugado(this);
          }
          else
              System.out.printf("O carro %s já foi alugado por outro cliente.\n", carroAlugado);
      }
      else{
          System.out.printf("O cliente %s já possui um carro alugado.\n",this.cpfFormatado);
      }
  }

  public void retornarCarro(){
      if (carroAtual == null){
          System.out.printf("O cliente %s não possui um carro alugado para devolver.\n", this.cpfFormatado);
      }
      else {
          carroAtual.carroFoiRetornado();
          this.carroAtual = null;
      }
  }

  public Carro getCarroAtual() {
      return this.carroAtual;
  }

  public String getMarcaDoCarroAtual(){
      return this.carroAtual.getMarcaDoCarro();
  }


  //=====CONTRATO DO CLIENTE =====
  
  public boolean isContrato() {
      return this.contrato;
  }

  public void assinarContrato() {
      this.contrato = true;
  }
  
}