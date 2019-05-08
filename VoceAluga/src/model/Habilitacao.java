package model;

import java.time.LocalDate;

public class Habilitacao {
  private String numeroDeRegistro;
  private LocalDate validade;
  private String categoria;
  private LocalDate dataDeEmissao;
  
  Habilitacao(){
	  
  }
  
  public Habilitacao(String numeroDeRegistro,String categoria,LocalDate validade,LocalDate dataDeEmissao){
	  this.numeroDeRegistro = numeroDeRegistro;
	  this.categoria = categoria;
	  this.validade = validade;
	  this.dataDeEmissao = dataDeEmissao;
  }
  
  
//  ---getters---
  public String getNumeroDeRegistro() {
	  return this.numeroDeRegistro;
  }
  
  public LocalDate getValidade() {
	  return this.validade;
  }
  
  public String getCategoria() {
	  return this.categoria;
  }
  
  public LocalDate getDataDeEmissao() {
	  return this.dataDeEmissao;
  }
  

}