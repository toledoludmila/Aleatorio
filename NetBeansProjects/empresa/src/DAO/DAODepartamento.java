/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Gene;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ludmila
 */
public class DAODepartamento {
    
    public static void viewdepartment(String sqlResultado){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        String sql = "";
        
        ConexaoBD con = new ConexaoBD();
        con.conectarEmpresa();
        
        sql = "CREATE OR REPLACE VIEW department AS SELECT * FROM departmentx WHERE" + sqlResultado +";";
        System.out.println(sql);
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.executeUpdate();
            
            conexao.commit();
            conexao.close();
            
        } catch (SQLException excecao){
            
            System.out.println("view-departamento: " + excecao.getMessage());
        }    
    }
    
    public static String buscarDepartment(ArrayList<Gene> listaGene){
        
        String sqlResultado ="";
        
        for (int i=0; i<listaGene.size(); i++){
            
            if (i == listaGene.size()-1){
                sqlResultado = sqlResultado + " dnumber = " + listaGene.get(i).getTupla();
            }else{
                sqlResultado = sqlResultado + " dnumber = " + listaGene.get(i).getTupla() + " OR";
            }
        }
        
        return sqlResultado;
    }
}