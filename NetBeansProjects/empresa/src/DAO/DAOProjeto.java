/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Projeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ludmila
 */
public class DAOProjeto {
    
    public void viewProject(int pnoId){
        
        PreparedStatement instrucao = null;
        Connection conexao = null;
        ResultSet resultado = null;
        String sql = "";
                
        sql = "USE empresa_teste; CREATE OR REPLACE VIEW `project` AS SELECT * FROM projectx WHERE pnumber = ?;;";
        //conexao = ConexaoBD.conectarEmpresa();
        
        try{
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, pnoId);
            resultado = instrucao.executeQuery();
            instrucao.executeUpdate();
            
            System.out.println(resultado);
                                  
        }catch(SQLException excecao){
            
            System.out.println("não executou consulta");
        }
    }
    
    public Projeto consulta(){
            
        Projeto projeto = null;
        PreparedStatement instrucao = null;
        Connection conexao = null;
        ResultSet resultado = null;
        String sql = "";
        
        ConexaoBD con = new ConexaoBD();
        
        sql = "SELECT * FROM projectx WHERE pnumber = 4999;";
        conexao = con.conectarEmpresaTeste();
                
        try{
            instrucao = conexao.prepareStatement(sql);
            resultado = instrucao.executeQuery();
                        
        }catch(SQLException excecao){
            
            System.out.println("não executou consulta");
        }
        return projeto;
    }
}