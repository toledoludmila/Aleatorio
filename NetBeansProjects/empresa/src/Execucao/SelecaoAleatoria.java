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
    
    public static int randInt(int min, int max) {
       /**
         * Metodo de selecao aleatoria
         * argumento: intervalo de tuplas da tabela
         */
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    public Individuo selecaoTuplas(int tamIndv) {
               
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
            int selTabela = randInt(1,2);
           /**
             * selecao aleatoria de tuplas
             */
            switch(selTabela){
                case 1:
                    /** 1 = Tabela Employee */
                    resultadoTupla = randInt(1,100000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo1.addGene(gene);

                    break;

                case 2:
                    /** 2 = Tabela Department */
                    resultadoTupla = randInt(1,1000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo2.addGene(gene);

                    break;

                case 3: 
                    /** 3 = Tabela Project */
                    resultadoTupla = randInt(1,5000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo3.addGene(gene);

                    break;

                case 4:
                    /** 4 = Tabela Works_on */
                    resultadoTupla = randInt(1,75000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo4.addGene(gene);

                    break;

                case 5:
                    /** 5 = Tabela Dependent */
                    resultadoTupla = randInt(1,50000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.addGene(gene);
                    individuo5.addGene(gene);

                    break;

                case 6:
                    /** 6 = Tabela Dept_Locations */
                    resultadoTupla = randInt(1,10000);
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