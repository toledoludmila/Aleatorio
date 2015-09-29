package Execucao;

//import static DAO.DAOInstrucaoOriginal.consultaInstrucao;

import static DAO.DAOInstrucaoOriginal.resultInstrucao;
import static DAO.DAOMutantes.resultMutantes;
import static Execucao.SelecaoAleatoria.selecaoGene;
import Modelo.Gene;
import Modelo.Populacao;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ludmila
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int tamInd = 30;
        int tamPop = 1;
        Populacao pop = null;
        
        ArrayList<Gene> individuo = new ArrayList<Gene>();
        //ArrayList<Populacao> populacao = new ArrayList<Populacao>();
        
        for (int i = 0; i< tamPop; i++){
            
            //individuo = selecaoGene(tamInd);
            
            //pop.setListaIndividuo(individuo);
            //populacao.add(pop);
                        
            TesteMutacao t = new TesteMutacao();
            t.compararResultados();
        }
        
        
    }   
}