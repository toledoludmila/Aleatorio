/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.InstrucaoOriginal;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author ludmila
 */
public class DAOInstrucaoOriginal {
    
    public static InstrucaoOriginal consultaInstrucao(int idInstOriginal){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        String sql = "";
        ResultSet resultado = null;
        InstrucaoOriginal instOriginal = new InstrucaoOriginal();
        
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarMutantes();
        
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
            conexao.close();
            
        } catch (SQLException excecao){
            
            System.out.println("instrucao original: " + excecao.getMessage());
        }
        return instOriginal;
    }  
    
    public static FileWriter resultInstrucao(String sql){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
        FileWriter fw = null;    
        
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarEmpresa();
        
        try {
            instrucao = conexao.prepareStatement(sql);
            resultado = instrucao.executeQuery();
                      
            ResultSetMetaData resultSetMetaData = resultado.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            
            fw = new FileWriter(new File("resultadoOriginal.txt"));        
            BufferedWriter bw = new BufferedWriter(fw);
            
            while (resultado.next()) {
                
                for (int i = 1; i <= count; i++) {

                    String info = resultado.getString(i);
                    bw.write(info + " ");
                    
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            conexao.close();
            
        } catch (SQLException | IOException excecao){
            
            System.out.println("resultIntrucao: " + excecao.getMessage());
        }   
        return fw;
    }
}