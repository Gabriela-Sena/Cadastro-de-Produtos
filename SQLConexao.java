//Alunas: Gabriela Sena da Silva e Luisa Pedrolli      2ºTI

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.mycompany.registro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gabriela
 */
public class SQLConexao {
    
    public static Connection getConexao() throws SQLException{
        
    Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/ifprtesteprodutos"+"?useTimeZone=true&serverTimeZone=UTC", "root", "");
        
        return conexao;
    }
    
    public static void adicionarProduto(Produto produto) throws SQLException{
        Connection conexao = getConexao();
        
        PreparedStatement declaracaoSQL;
        
        declaracaoSQL =
                 conexao.prepareStatement("insert into produtos(nomeProduto, quantidade, preco,tipo)"+ "values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        
    
        declaracaoSQL.setString(1, produto.getNomeProduto());
        declaracaoSQL.setInt(2, produto.getQuantidade());
        declaracaoSQL.setDouble(3, produto.getPreco());
        declaracaoSQL.setString(4, produto.getTipo());
        declaracaoSQL.execute();
        
        ResultSet resultado = declaracaoSQL.getGeneratedKeys(); 
        resultado.next();
        int cod = resultado.getInt(1);
        produto.setCod(cod);
        
    }

    public static void carregarRegistros(ProdutoTableModel tabelaproduto) throws SQLException{
      Connection conexao = getConexao();
      
      Statement declaracaoSQL = conexao.createStatement();
      ResultSet resultado = declaracaoSQL.executeQuery("select * from produtos ");
      
        while(resultado.next()){
            String nomeProduto = resultado.getString("nomeProduto");
            int cod = resultado.getInt("cod");
            int quantidade = resultado.getInt("quantidade");
            double preco = resultado.getDouble("preco");
            String tipo = resultado.getString("tipo");
          
            Produto produto = new Produto( cod, nomeProduto, quantidade, preco,tipo);
            
            tabelaproduto.adicionarProduto(produto);
            
        }
    }
    
    public static void deletarRegistro(int cod) throws SQLException{
        
        Connection conexao = getConexao();
        
        PreparedStatement declaracaoSQL;
        declaracaoSQL = conexao.prepareStatement("delete from produtos where cod = ?");
        declaracaoSQL.setInt(1,cod);
        declaracaoSQL.execute();
        
    }
    
    public static void alterarRegistro(String nomeProduto,int quantidade, double preco,String tipo, int cod ) throws SQLException{
        
        Connection conexao = getConexao();
        
        PreparedStatement declaracaoSQL;
        declaracaoSQL = conexao.prepareStatement("Update produtos set nomeProduto = ?, quantidade = ?, preco = ?, tipo = ? where cod = ? ");
        declaracaoSQL.setString(1,nomeProduto);
        declaracaoSQL.setInt(2,quantidade);
        declaracaoSQL.setDouble(3,preco);
        declaracaoSQL.setString(4,tipo);
        declaracaoSQL.setInt(5,cod);
        declaracaoSQL.execute();
        
    }
    
}
