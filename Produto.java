//Alunas: Gabriela Sena da Silva e Luisa Pedrolli      2ºTI

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.registro;

/**
 *
 * @author Gabriela
 */
public class Produto {
    private String nomeProduto;
    private int cod;
    private int quantidade;
    private double preco;
    private String tipo; 
        
    public Produto(int cod, String nomeProduto, int quantidade, double preco, String tipo) {
    this.cod = cod;
    this.nomeProduto = nomeProduto;
    this.quantidade = quantidade;
    this.preco = preco;
    this.tipo = tipo;
    }
      
    
    public Produto(String nomeProduto, int quantidade, double preco,String tipo) {
    this.nomeProduto = nomeProduto;
    this.quantidade = quantidade;
    this.preco = preco;
    this.tipo = tipo;
    }
       
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    } 

    public String getTipo() { //ok
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
