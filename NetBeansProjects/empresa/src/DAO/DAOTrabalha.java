/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Trabalha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ludmila
 */
public class DAOTrabalha {
     
    public void viewWorksOn(int trId){
        
        PreparedStatement instrucao = null;
        Connection conexao = null;
        ResultSet resultado = null;
        String sql = "";
                
        sql = "USE empresa_teste; CREATE OR REPLACE VIEW `works_on` AS SELECT * FROM works_onx WHERE id = ?;;";
        //conexao = ConexaoBD.conectarEmpresa();
        
        try{
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, trId);
            resultado = instrucao.executeQuery();
            
            System.out.println(resultado);
                                  
        }catch(SQLException excecao){
            
            System.out.println("não executou consulta");
        }
    }
}