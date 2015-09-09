/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ludmila
 */
public class DAOLocalDpt {
        
    public void viewDeptLocations(int dptId){
        
        PreparedStatement instrucao = null;
        Connection conexao = null;
        ResultSet resultado = null;
        String sql = "";
                
        sql = "USE empresa_teste; CREATE OR REPLACE VIEW `dept_locations` AS SELECT * FROM dept_locationsx WHERE id = ?;;";
        //conexao = ConexaoBD.conectarEmpresa();
        
        try{
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, dptId);
            resultado = instrucao.executeQuery();
            
            System.out.println(resultado);
                                  
        }catch(SQLException excecao){
            
            System.out.println("não executou consulta");
        }
    }
}