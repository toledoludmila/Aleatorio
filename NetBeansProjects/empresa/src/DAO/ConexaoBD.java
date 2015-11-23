/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ludmila
 */
public class ConexaoBD {
       
    public Connection conectarEmpresa(){
        
        Connection conexao = null;
        //String urlEmpresa = "jdbc:mysql://localhost:3306/empresa";
        //String urlEmpresa = "jdbc:mysql://localhost:3306/empresa_ludmila";
        String urlEmpresa = "jdbc:mysql://localhost:3306/empresa_leonardo";
        String username = "root";
        String password = "senha";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection(urlEmpresa, username, password);
            // Desabilita o commit automático para que seja possível fazer rollback.
            conexao.setAutoCommit(false);
                                   
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            
            System.out.println("Conectar empresa: " + ex.getMessage());
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
            
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            
            System.out.println("Conectar mutantes: " + ex.getMessage());
        }
        return conexao;
    }   
}