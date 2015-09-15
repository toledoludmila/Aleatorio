/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Mutantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ludmila
 */
public class DAOMutantes {
    
    public static ArrayList<Mutantes> consultaMutantes(int idInst){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        String sql = "";
        ResultSet resultado = null;
        ArrayList<Mutantes> listaMutantes = null;
        //variaveis mutantes 
        
        int id;
        String categoria ;
        String tipo;
        String sqlMutante;
        int idInstrucao;
                
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarMutantes();
        
        sql = "SELECT * FROM mutantes WHERE id_instrucao = ?;";
        
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, idInst);
            resultado = instrucao.executeQuery();
            
            listaMutantes = new ArrayList<Mutantes>();
            
            while(resultado.next()){
                
                id = resultado.getInt(1);
                categoria = resultado.getString(2);
                tipo = resultado.getString(3);
                sqlMutante = resultado.getString(4);
                idInstrucao = resultado.getInt(5);
                
                Mutantes mutantes = new Mutantes();
                
                mutantes.setId(id);
                mutantes.setCategoria(categoria);
                mutantes.setTipo(tipo);
                mutantes.setSqlMutante(sqlMutante);
                mutantes.setIdInstrucao(idInstrucao);
                
                listaMutantes.add(mutantes);
            }
            conexao.close();
            
        } catch (SQLException excecao){
            
            System.out.println("instrucoes mutantes: " + excecao.getMessage());
        }
        
        return listaMutantes;
    }
    
    public static ResultSet resultMutantes(String sql){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
                
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarEmpresa();
        
        try {
            instrucao = conexao.prepareStatement(sql);
            resultado = instrucao.executeQuery();
            
            //conexao.close();
            
        } catch (SQLException excecao){
            
            System.out.println("Consulta Instrucao: " + excecao.getMessage());
        }    
        return resultado;
    
    }
}
