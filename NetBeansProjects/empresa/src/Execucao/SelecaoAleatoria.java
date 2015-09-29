/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execucao;

import static DAO.DAODepartamento.buscarDepartment;
import static DAO.DAODepartamento.viewDepartment;
import static DAO.DAODependente.buscarDependent;
import static DAO.DAODependente.viewDependent;
import static DAO.DAOEmpregado.buscarEmployee;
import static DAO.DAOEmpregado.viewEmployee;
import static DAO.DAOLocalDpt.buscarDeptLocations;
import static DAO.DAOLocalDpt.viewDeptLocations;
import static DAO.DAOProjeto.buscarProject;
import static DAO.DAOProjeto.viewProject;
import static DAO.DAOTrabalha.buscarWorksOn;
import static DAO.DAOTrabalha.viewWorksOn;
import Modelo.Gene;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ludmila
 */
public class SelecaoAleatoria {
    
    public static int randInt(int min, int max) {
        
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    public static ArrayList<Gene> selecaoGene(int indv){
               
        int resultadoTupla;
        
        ArrayList<Gene> individuo = new ArrayList<Gene>();
        
        ArrayList<Gene> individuo1 = new ArrayList<Gene>();
        ArrayList<Gene> individuo2 = new ArrayList<Gene>();
        ArrayList<Gene> individuo3 = new ArrayList<Gene>();
        ArrayList<Gene> individuo4 = new ArrayList<Gene>();
        ArrayList<Gene> individuo5 = new ArrayList<Gene>();
        ArrayList<Gene> individuo6 = new ArrayList<Gene>(); 
        
        for (int i =0; i< indv; i++){
            Gene gene = new Gene();
            int selTabela = randInt(1,3);
            
            switch(selTabela){
                case 1:
                    
                    resultadoTupla = randInt(1,100000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.add(gene);
                    individuo1.add(gene);

                    break;

                case 2:
                    
                    resultadoTupla = randInt(1,1000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.add(gene);
                    individuo2.add(gene);

                    break;

                case 3: 
                    resultadoTupla = randInt(1,5000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.add(gene);
                    individuo3.add(gene);

                    break;

                case 4:
                    resultadoTupla = randInt(1,75000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.add(gene);
                    individuo4.add(gene);

                    break;

                case 5:
                    resultadoTupla = randInt(1,50000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.add(gene);
                    individuo5.add(gene);

                    break;

                case 6:
                    resultadoTupla = randInt(1,10000);
                    gene.setTabela(selTabela);
                    gene.setTupla(resultadoTupla);
                    individuo.add(gene);
                    individuo6.add(gene);

                    break;
            }
        }
        
        if (!individuo1.isEmpty()) {
            String sqlResultado1 = buscarEmployee(individuo1);
            viewEmployee(sqlResultado1);
        }
        
        if (!individuo2.isEmpty()){
            String sqlResultado2 = buscarDepartment(individuo2);
            viewDepartment(sqlResultado2);
        }
        
        if(!individuo3.isEmpty()){
            String sqlResultado3 = buscarProject(individuo3);
            viewProject(sqlResultado3);
        }
        
        if(!individuo4.isEmpty()){
            String sqlResultado4 = buscarWorksOn(individuo4);
            viewWorksOn(sqlResultado4);
        }
        
        if(!individuo5.isEmpty()){
            String sqlResultado5 = buscarDependent(individuo5);
            viewDependent(sqlResultado5);
        }
        
        if(!individuo6.isEmpty()){
            String sqlResultado6 = buscarDeptLocations(individuo6);
            viewDeptLocations(sqlResultado6);
        }
        
        return individuo;
    }         
}