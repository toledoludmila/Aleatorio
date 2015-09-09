/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ludmila
 */
public class ConexaoBD {
       
    public Connection conectarEmpresaTeste(){
        
        Connection conexao = null;
        String urlEmpresa = "jdbc:mysql://localhost:3306/empresa_teste";
        String username = "root";
        String password = "senha";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection(urlEmpresa, username, password);
            // Desabilita o commit automático para que seja possível fazer rollback.
            conexao.setAutoCommit(false);
            System.out.println("conectou Banco empresa teste");
                       
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
    
    public Connection conectarEmpresa(){
        
        Connection conexao = null;
        String urlEmpresa = "jdbc:mysql://localhost:3306/empresa";
        String username = "root";
        String password = "senha";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection(urlEmpresa, username, password);
            // Desabilita o commit automático para que seja possível fazer rollback.
            conexao.setAutoCommit(false);
            System.out.println("conectou Banco empresa");
                       
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
    
    public Connection conectarMutantes(){
        
        Connection conexao = null;
        String urlMutantes = "jdbc:mysql://localhost:3306/mutantes";
        String username = "root";
        String password = "senha";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection(urlMutantes, username, password);
            // Desabilita o commit automático para que seja possível fazer rollback.
            conexao.setAutoCommit(false);
            System.out.println("conectou Banco mutantes");
            
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
    
}