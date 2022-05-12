//Alunas: Gabriela Sena da Silva e Luisa Pedrolli      2ºTI

package com.mycompany.registro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gabriela
 */
public class ProdutoTableModel extends AbstractTableModel{
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    String[] nomesColunas = { "Código", "Produto", "Quantidade", "Preço", "Tipo"}; //OK
    
    @Override
    public int getRowCount() { //retornar o numero de linhas
        return produtos.size();
    }

    @Override
    public String getColumnName(int column) { //definir os nomes das colunas
        return nomesColunas[column];
    }

    @Override
    public int getColumnCount() { //retornar o numeros de colunas
        return nomesColunas.length;
    }
    
    
    
    @Override
    public Object getValueAt(int linha, int coluna) { //saber quantas colunas tem, etc, pegar dados da tabela
        switch(coluna){
            case 0:
                return produtos.get(linha).getCod();
            case 1:
                return produtos.get(linha).getNomeProduto();
            case 2:
                return produtos.get(linha).getQuantidade();
            case 3:
                return produtos.get(linha).getPreco();
            case 4:
                return produtos.get(linha).getTipo();
            default:
                return null;
        }
    }
    
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
        
        this.fireTableRowsInserted(produtos.size()-1, produtos.size()-1); //menos 1 pois é a ultima linha da tabela
    }
    
    public void removerProduto(int linha){
        produtos.remove(linha);
        
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void alterarProduto(Produto produto, int linha){
        produtos.set(linha, produto);
        
        this.fireTableRowsUpdated(linha, linha);
    }  
    
    public void limparTabela(){
        produtos.clear();
        
        this.fireTableDataChanged();
    }
    
    Produto getProduto(int linha) {
        return produtos.get(linha);
    }
}


