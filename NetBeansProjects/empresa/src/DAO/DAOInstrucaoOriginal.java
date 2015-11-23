/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.InstrucaoOriginal;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ludmila
 */
public class DAOInstrucaoOriginal {
    
    public InstrucaoOriginal buscarInstOrig(int idInstOriginal){
        Connection conexao = null;
        PreparedStatement instrucao = null;
        String sql = "";
        ResultSet resultado = null;
        
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarMutantes();
        
        InstrucaoOriginal instOriginal = new InstrucaoOriginal();
        sql = "SELECT * FROM instrucoes WHERE id = ?;";
        
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, idInstOriginal);
            resultado = instrucao.executeQuery();
            
            if (!resultado.next()){
                instOriginal = null;
            } else {
                int id = resultado.getInt(1);
                String comando = resultado.getString(2);
                
                instOriginal.setId(id);
                instOriginal.setComando(comando);
            }
            instrucao.close();
            conexao.close();
            
        } catch (SQLException excecao){
            System.out.println("instrucao original: " + excecao.getMessage());
        }
        return instOriginal;
    }  
    
    public void testarInstOrig(String sql){
        Connection conexao = null;
        PreparedStatement instrucao = null;
        FileWriter fw = null;    
        
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarEmpresa();
        sql = sql.toLowerCase();
        try {
            instrucao = conexao.prepareStatement(sql + " into outfile '/tmp/Resultados/resultadoOriginal.txt';");
            instrucao.executeQuery();
                  
            instrucao.close();
            conexao.close();   
        } catch (SQLException ex){
            
            System.out.println("resultIntrucao: " + ex.getMessage());
        }   
    }
}