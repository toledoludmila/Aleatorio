package Execucao;

//import Modelo.Gene;
import Modelo.Mutante;
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
        float somaescore = 0;
        int tamInd = 100;
        int tamPop = 1;
        
        //Populacao populacao = new Populacao(tamPop);
        
        long tempoInicial = System.currentTimeMillis();
        
        ArrayList<Mutante> listaMutantes = new ArrayList<Mutante>();
        for (int i = 0; i < tamPop; i++) {
            SelecaoAleatoria sa = new SelecaoAleatoria();
            sa.selecaoTuplas(tamInd);
                        
            TesteMutacao t = new TesteMutacao();
            listaMutantes = t.resultadosMd5(2);
            float escore = t.escoreMutacao(listaMutantes);
            
            somaescore = somaescore + escore;
        }
        
        float mediaescore = somaescore / tamPop;
        System.out.println("Soma dos Escores de mutacao: " + somaescore);
        System.out.println("Media dos escores de mutacao: " + mediaescore);
        
        long tempoTotal = System.currentTimeMillis() - tempoInicial;
        System.out.println("Tempo de execucao: " + tempoTotal + " ms");
    }   
}