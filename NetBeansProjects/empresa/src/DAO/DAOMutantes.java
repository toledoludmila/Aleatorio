/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Mutante;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ludmila
 */
public class DAOMutantes {
    
    public ArrayList<Mutante> buscarMutantes(int idInst){
        Connection conexao = null;
        PreparedStatement instrucao = null;
        String sql = "";
        ResultSet resultado = null;
        ArrayList<Mutante> listaMutantes = null;
        //variaveis mutantes 
        int id;
        String categoria ;
        String tipo;
        String sqlMutante;
                        
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarMutantes();
        
        sql = "SELECT * FROM mutantes WHERE id_instrucao = ?;";
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, idInst);
            resultado = instrucao.executeQuery();
            
            listaMutantes = new ArrayList<Mutante>();
            
            while(resultado.next()){
                
                id = resultado.getInt(1);
                categoria = resultado.getString(2);
                tipo = resultado.getString(3);
                sqlMutante = resultado.getString(4);
                                
                Mutante mutantes = new Mutante();
                
                mutantes.setId(id);
                mutantes.setCategoria(categoria);
                mutantes.setTipo(tipo);
                mutantes.setSqlMutante(sqlMutante);
                mutantes.setIdInstrucao(idInst);
                
                listaMutantes.add(mutantes);
            }
            conexao.close();
            
        } catch (SQLException excecao){
            System.out.println("instrucoes mutantes: " + excecao.getMessage());
        }
        return listaMutantes;
    }
    
    public void testarMutantes(String sql, String arquivoMutante){
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
            int countColunas = resultSetMetaData.getColumnCount();
            
            fw = new FileWriter(new File(arquivoMutante));        
            BufferedWriter bw = new BufferedWriter(fw);
            
            while (resultado.next()) {
                
                for (int i = 1; i <= countColunas; i++) {
                    String info = resultado.getString(i);
                    bw.write(info + " ");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            conexao.close();
              
        } catch (SQLException | IOException excecao){
            System.out.println("resultMutantes: " + excecao.getMessage());
        }    
    }
}