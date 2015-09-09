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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ludmila
 */
public class DAODependente {
    
    public void viewDependent(int depId){
        
        PreparedStatement instrucao = null;
        Connection conexao = null;
        ResultSet resultado = null;
        String sql = "";
                
        sql = "ALTER VIEW dependent AS SELECT * FROM dependentx WHERE sel = 'y';";
        //conexao = ConexaoBD.conectarEmpresa();
        
        try{
            instrucao = conexao.prepareStatement(sql);
            instrucao.executeUpdate();
                                  
        }catch(SQLException excecao){
            
            System.out.println("não executou consulta");
        }
    }
    
    public void alterDependentx(int ssnId){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
        String sql = "";
        
        ConexaoBD con = new ConexaoBD();
        
        sql = "UPDATE dependentx SET sel = 'y' where ssn = ?;";
        conexao = con.conectarEmpresaTeste();
        
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, ssnId);
            instrucao.executeUpdate();
            //conexao.commit();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DAOEmpregado.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}