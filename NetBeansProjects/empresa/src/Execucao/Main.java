package Execucao;

//import Modelo.Gene;
import Modelo.Mutante;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
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
public class Main extends Logs{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double somaescore = 0; 
        int tamInd = 1000;
        int tamPop = 30;
        int idInstrucao = 19;
        double menorFitness = 1.01, maiorFitness = -0.1;
        
        NumberFormat doubleFormat = NumberFormat.getInstance();
        doubleFormat.setMaximumFractionDigits(4);
        
        //Populacao populacao = new Populacao(tamPop);
                
        Main main = new Main();
        //Main.arquivo = new File("Logs/experimentoBDP" + "_instrucao_" + idInstrucao + ".log");
        Main.arquivo = new File("Logs/experimentoBDT_" + tamPop + "x" + tamInd 
                + "_instrucao_" + idInstrucao + ".log");
        
        try {
            Main.fr = new FileWriter(Main.arquivo);
        } catch (IOException ex) {
            System.out.println("Erro IO experimento.log :" + ex.getMessage());
        }
        
        long tempoInicial = System.currentTimeMillis();
        
        registrarLog("Iniciando teste da instrucao: " + idInstrucao);
        
        ArrayList<Mutante> listaMutantes = new ArrayList<Mutante>();
        for (int i = 0; i < tamPop; i++) {
            SelecaoAleatoria sa = new SelecaoAleatoria();
            sa.selecaoTuplas(tamInd);
            
            TesteMutacao t = new TesteMutacao();
            listaMutantes = t.resultadosMd5(idInstrucao);
            double escore = t.escoreMutacao(listaMutantes);
            
            if(escore > maiorFitness){
                maiorFitness = escore;
            }
            
            if(escore < menorFitness){
                menorFitness = escore;
            }
            
            somaescore = somaescore + escore;
            try {
                ProcessBuilder pb = new ProcessBuilder("rmtxt.sh");
                pb.redirectErrorStream(true);
                pb.directory(new File("/tmp/Resultados"));
                Process p = pb.start();
                p.waitFor();
                p.destroy();
            
            } catch (IOException | InterruptedException ex) {
                System.out.println("rm : " + ex.getMessage());
            } 
        }
              
        double mediaescore = somaescore / tamPop;
        //double desviopadrao = Math.sqrt(somaquadrado);
        registrarLog("Soma dos Escores de mutacao: " + doubleFormat.format(somaescore));
        registrarLog("Maior escore de mutacao: " + doubleFormat.format(maiorFitness));
        registrarLog("Menor escore de mutacao: " + doubleFormat.format(menorFitness));
        registrarLog("Media dos escores de mutacao: " + doubleFormat.format(mediaescore));
        //System.out.println("Desvio Padrão: " + desviopadrao);
        
        long tempoTotal = System.currentTimeMillis() - tempoInicial;
        registrarLog("Tempo de execucao: " + tempoTotal + " ms");
        
        try {
            fr.close();
        } catch (IOException ex) {
            System.out.println("Erro IO experimento.log close :" + ex.getMessage());
        }
    }   
}