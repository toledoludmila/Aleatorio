/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import static DAO.DAOEmpregado.buscarEmployee;
import static DAO.DAOEmpregado.viewEmployee;
import Modelo.Gene;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ludmila
 */
public class SelecaoAleatoria {
    
    static Random rand = new Random();
    
    public static int randInt(int min, int max) {

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    public static Gene selecaoGene(int selTabela){
               
        int resultadoTupla;
            
        Gene gene = new Gene();
        //DAOEmpregado daoEmp = new DAOEmpregado();    
        
        switch(selTabela){
            case 1:
                resultadoTupla = randInt(1,100000);
                gene.setTabela(selTabela);
                gene.setTupla(resultadoTupla);
                                
                break;
                    
            case 2:
                resultadoTupla = randInt(1,1000);
                gene.setTabela(selTabela);
                gene.setTupla(resultadoTupla);

                break;
                    
            case 3: 
                resultadoTupla = randInt(1,5000);
                gene.setTabela(selTabela);
                gene.setTupla(resultadoTupla);

                break;

            case 4:
                resultadoTupla = randInt(1,75000);
                gene.setTabela(selTabela);
                gene.setTupla(resultadoTupla);

                break;

            case 5:
                resultadoTupla = randInt(1,50000);
                gene.setTabela(selTabela);
                gene.setTupla(resultadoTupla);

                break;

            case 6:
                resultadoTupla = randInt(1,10000);
                gene.setTabela(selTabela);
                gene.setTupla(resultadoTupla);

                break;
        }
              
        return gene;
    }  
    
    public static void resultIndividuo(int indv){
        
        //ArrayList<ResultSet> listaResultado = new ArrayList<ResultSet>();
        ArrayList<Gene> listaGene = new ArrayList<Gene>();
        Gene gene;
                
        for (int i =0; i< indv; i++){
            
            int selTabela = 1;//randInt(2,3);
            gene = new Gene();
            
            gene = selecaoGene(selTabela);
            listaGene.add(gene);
            
        }
        String resultado = buscarEmployee(listaGene);
        System.out.println(resultado);
        viewEmployee(resultado);
           
    }
    

}