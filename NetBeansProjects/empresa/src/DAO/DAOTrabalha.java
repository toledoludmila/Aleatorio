/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Gene;
import Modelo.Individuo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ludmila
 */
public class DAOTrabalha {
     
    public void criarViewWorksOn(String sqlResultado){
        Connection conexao = null;
        PreparedStatement instrucao = null;
        String sql = "";
        
        ConexaoBD con = new ConexaoBD();
        conexao = con.conectarEmpresa();
        
        sql = "CREATE OR REPLACE VIEW works_on AS SELECT * FROM works_onx WHERE" + sqlResultado +";";
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.executeUpdate();
            
            conexao.commit();
            conexao.close();
            
        } catch (SQLException excecao){
            System.out.println("view-workson: " + excecao.getMessage());
        }    
    }
    
    public String buscarWorksOn(Individuo individuo){
        String sqlResultado ="";
        /**
         *monta string que será passada para criar a view 
         */
        ArrayList<Gene> listaGene = individuo.getListaGenes();
        for (int i=0; i<listaGene.size(); i++){
            if (i == listaGene.size()-1){
                sqlResultado = sqlResultado + " id = " + listaGene.get(i).getTupla();
            }else{
                sqlResultado = sqlResultado + " id = " + listaGene.get(i).getTupla() + " OR";
            }
        }
        return sqlResultado;
    }
}