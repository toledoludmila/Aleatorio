/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execucao;

import DAO.DAODepartamento;
import DAO.DAODependente;
import DAO.DAOEmpregado;
import DAO.DAOLocalDpt;
import DAO.DAOProjeto;
import DAO.DAOTrabalha;
import Modelo.Gene;
import Modelo.Individuo;
import java.util.Random;

/**
 *
 * @author ludmila
 */
public class SelecaoAleatoria {
    
    /*public static int randInt(int min, int max) {
       /**
         * Metodo de selecao aleatoria
         * argumento: intervalo de tuplas da tabela
         */
        /*Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }*/
    
    public int escolheTabela(int i){
        int selTabela;
        
        if(i <= 705){
            selTabela = 0;
            return selTabela;  
        }else{
            selTabela = 1;
            return selTabela;
        }
    }
    
    public Individuo selecaoTuplas(int tamIndv) {
        Random rand = new Random();
               
        int resultadoTupla;
        
        Individuo individuo = new Individuo();
        
        Individuo individuo1 = new Individuo();
        Individuo individuo2 = new Individuo();
        Individuo individuo3 = new Individuo();
        Individuo individuo4 = new Individuo();
        Individuo individuo5 = new Individuo();
        Individuo individuo6 = new Individuo(); 
        
        for (int i = 0; i < tamIndv; i++){
            Gene gene = new Gene();
            int selTabela = rand.nextInt(2);
            
            //int selTabela = escolheTabela(i);
           /**
             * selecao aleatoria de tuplas
             */
            switch(selTabela){
                case 0:
                    /** 1 = Tabela Employee */
                    resultadoTupla = rand.nextInt(100000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo1.addGene(gene);
                    //System.out.println("tabela: " + selTabela +" Tupla: " + resultadoTupla);
                    break;

                case 1:
                    /** 2 = Tabela Department */
                    resultadoTupla = rand.nextInt(1000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo2.addGene(gene);
                    //System.out.println("tabela: " + selTabela +" Tupla: " + resultadoTupla);
                    break;

                case 2: 
                    /** 3 = Tabela Project */
                    resultadoTupla = rand.nextInt(5000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo3.addGene(gene);
                    //System.out.println("tabela: " + selTabela +" Tupla: " + resultadoTupla);
                    break;

                case 3:
                    /** 4 = Tabela Works_on */
                    resultadoTupla = rand.nextInt(75000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo4.addGene(gene);

                    break;

                case 4:
                    /** 5 = Tabela Dependent */
                    resultadoTupla = rand.nextInt(50000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo5.addGene(gene);

                    break;

                case 5:
                    /** 6 = Tabela Dept_Locations */
                    resultadoTupla = rand.nextInt(10000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo6.addGene(gene);

                    break;
            }
        }
        /**
         * passa genes employee para 
         * criar view employee 
         */
        if (!individuo1.estaVazio()) {
            DAOEmpregado daoEmp = new DAOEmpregado();
            String sqlResultado1 = daoEmp.buscarEmployee(individuo1);
            daoEmp.criarViewEmployee(sqlResultado1);
        }
        /**
         * passa genes department para 
         * criar view department 
         */
        if (!individuo2.estaVazio()){
            DAODepartamento daoDpt = new DAODepartamento();
            String sqlResultado2 = daoDpt.buscarDepartment(individuo2);
            daoDpt.criarViewDepartment(sqlResultado2);
        }
        /**
         * passa genes project para 
         * criar view proect 
         */
        if(!individuo3.estaVazio()){
            DAOProjeto daoPrj = new DAOProjeto();
            String sqlResultado3 = daoPrj.buscarProject(individuo3);
            daoPrj.criarViewProject(sqlResultado3);
        }
        /**
         * passa genes works_on para 
         * criar view works_on 
         */
        if(!individuo4.estaVazio()){
            DAOTrabalha daoTrb = new DAOTrabalha();
            String sqlResultado4 = daoTrb.buscarWorksOn(individuo4);
            daoTrb.criarViewWorksOn(sqlResultado4);
        }
        /**
         * passa genes dependent para 
         * criar view dependent 
         */
        if(!individuo5.estaVazio()){
            DAODependente daoDep = new DAODependente();
            String sqlResultado5 = daoDep.buscarDependent(individuo5);
            daoDep.criarViewDependent(sqlResultado5);
        }
        /**
         * passa genes dept_locations para 
         * criar view dept_locations 
         */
        if(!individuo6.estaVazio()){
            DAOLocalDpt daoLoc = new DAOLocalDpt();
            String sqlResultado6 = daoLoc.buscarDeptLocations(individuo6);
            daoLoc.criarViewDeptLocations(sqlResultado6);
        }
        
        return individuo;
    }         
}