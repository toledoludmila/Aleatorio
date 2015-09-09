/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empregado;
import Modelo.Gene;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ludmila
 */
public class DAOEmpregado {
    
    public static void insertEmployee(ArrayList<Empregado> listaEmp){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
        String sql = "";
        
        ConexaoBD con = new ConexaoBD();
        
        for(Empregado empregado : listaEmp) {
            
            sql = "INSERT INTO employeex VALUES (?,?,?,?,?,?,?,?,?,?);";
            conexao = con.conectarEmpresaTeste();
        
            try{
                instrucao = conexao.prepareStatement(sql);

                instrucao.setString(1,empregado.getFname());
                instrucao.setString(2,empregado.getMinit());
                instrucao.setString(3,empregado.getLname());
                instrucao.setInt(4,empregado.getSsn());
                instrucao.setDate(5, (java.sql.Date) empregado.getBdate());
                instrucao.setString(6,empregado.getAddress());
                instrucao.setString(7,empregado.getSex());
                instrucao.setFloat(8, empregado.getSalary());
                instrucao.setInt(9,empregado.getSuperssn());
                instrucao.setInt(10,empregado.getDno());

                instrucao.executeUpdate();
                conexao.commit();

            }catch(SQLException excecao){

                System.out.println("insertEmployee - não executou update");
            }
        }
    }
    
    public static Empregado buscaEmployeex(Gene gene){
        
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
        String sql = "";
        Empregado empregado = null;

        ConexaoBD con = new ConexaoBD();
        
        sql = "SELECT * FROM employees WHERE ssn = ?;";
        conexao = con.conectarEmpresa();
        
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, gene.getTupla());
            resultado = instrucao.executeQuery();
            
            if (!resultado.next()){
                
                empregado = null;
                
            }else{
                empregado = new Empregado();
                
                String fname = resultado.getString(1);
                String minit = resultado.getString(2);
                String lname = resultado.getString(3);
                int ssn = resultado.getInt(4);
                Date bdate = resultado.getDate(5);
                String address = resultado.getString(6);
                String sex = resultado.getString(7);
                float salary = resultado.getFloat(8);
                int superssn = resultado.getInt(9);
                int dno = resultado.getInt(10);
                
                empregado.setFname(fname);
                empregado.setMinit(minit);
                empregado.setLname(lname);
                empregado.setSsn(ssn);
                empregado.setBdate(bdate);
                empregado.setAddress(address);
                empregado.setSex(sex);
                empregado.setSalary(salary);
                empregado.setSuperssn(superssn);      
                empregado.setDno(dno);
            }
            
        } catch (SQLException excecao){
            
            System.out.println("busca-empregado: " + excecao.getMessage());
        }
        
        return empregado;
    }
    
    public static Empregado refEmployee(Gene gene){
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
        String sql = "";
        Empregado empregado = null;
        
        ConexaoBD con = new ConexaoBD();
        
        sql = "SELECT * FROM employees WHERE ssn = (SELECT superssn FROM employees WHERE ssn = ?);";
        conexao = con.conectarEmpresa();
        
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, gene.getTupla());
            resultado = instrucao.executeQuery();
            
            if (!resultado.next()){
                
                empregado = null;
                
            }else{
                empregado = new Empregado();
                
                String fname = resultado.getString(1);
                String minit = resultado.getString(2);
                String lname = resultado.getString(3);
                int ssn = resultado.getInt(4);
                Date bdate = resultado.getDate(5);
                String address = resultado.getString(6);
                String sex = resultado.getString(7);
                float salary = resultado.getFloat(8);
                int superssn = resultado.getInt(9);
                int dno = resultado.getInt(10);
                
                empregado.setFname(fname);
                empregado.setMinit(minit);
                empregado.setLname(lname);
                empregado.setSsn(ssn);
                empregado.setBdate(bdate);
                empregado.setAddress(address);
                empregado.setSex(sex);
                empregado.setSalary(salary);
                empregado.setSuperssn(superssn);      
                empregado.setDno(dno);
                
            }
            
        } catch (SQLException excecao){
            
            System.out.println("busca-refempregado: " + excecao.getMessage());
        }
        return empregado;
    }
    
    public static void limparEmployee(){
        Connection conexao = null;
        PreparedStatement instrucao = null;
        ResultSet resultado = null;
        String sql = "";
              
        ConexaoBD con = new ConexaoBD();
        
        sql = "DELETE FROM employeex WHERE ssn > 0;";
        conexao = con.conectarEmpresaTeste();
        
        try {
            instrucao = conexao.prepareStatement(sql);
            instrucao.executeUpdate();
            conexao.commit();
            
        } catch (SQLException excecao){
            
            System.out.println("limpar-empregado: " + excecao.getMessage());
        }
    }
 
}