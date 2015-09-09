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
public class DAODepartamento {
    
    public void viewDepartment(){
        
        PreparedStatement instrucao = null;
        Connection conexao = null;
        ResultSet resultado = null;
        String sql = "";
                
        ConexaoBD con = new ConexaoBD();
        
        sql = "ALTER VIEW department AS SELECT * FROM departmentx WHERE ssn = ?;";
        //conexao = ConexaoBD.conectarEmpresa();
        
        try{
            instrucao = conexao.prepareStatement(sql);
            //instrucao.setInt(1, dnoId);
            instrucao.executeUpdate();
            conexao.commit();
                                  
        }catch(SQLException excecao){
            
            System.out.println("não executou consulta");
        }
    }
    
    public void alterDepartmentx(int ssnId){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
        String sql = "";
        
        ConexaoBD con = new ConexaoBD();
        
        sql = "UPDATE departmentx SET sel = 'y' where ssn = ?;";
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