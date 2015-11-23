/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execucao;

import DAO.DAOInstrucaoOriginal;
import DAO.DAOMutantes;
import static Execucao.Logs.registrarLog;
import Modelo.InstrucaoOriginal;
import Modelo.Mutante;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author ludmila
 */
public class TesteMutacao {
        
    public ArrayList<Mutante> resultadosMd5(int idInstOrig) {
        
        InstrucaoOriginal instOrig = new InstrucaoOriginal();
        DAOInstrucaoOriginal daoInst = new DAOInstrucaoOriginal();
        DAOMutantes daoInstMut = new DAO.DAOMutantes();
        ArrayList<Mutante> listaMutantes = new ArrayList<Mutante>();
        
        instOrig = daoInst.buscarInstOrig(idInstOrig);
        listaMutantes = daoInstMut.buscarMutantes(idInstOrig);
        
        /**
          * gera o arquivo resultadoOriginal.txt
          */
        String sqlOrig = instOrig.getComando();
        DAOInstrucaoOriginal daoInstRes = new DAOInstrucaoOriginal();
        daoInstRes.testarInstOrig(sqlOrig);
        
        /**
         * Executa o md5deep para o resultadoOriginal.txt
         */
        try {
            ProcessBuilder pbo = new ProcessBuilder("md5deep", "-q", "/tmp/Resultados/resultadoOriginal.txt", "-W", "md5Original.txt");
            pbo.redirectErrorStream(true);
            Process po = pbo.start();
            po.waitFor();
            po.destroy();
            
        } catch (IOException | InterruptedException ex) {
            System.out.println("md5Deep: " + ex.getMessage());
        }
        
        
        for (int i = 0; i < listaMutantes.size(); i++) {
            /**
             * Gera o arquivo resultadoMutante_i.txt
             */
            String sqlMutante = listaMutantes.get(i).getSqlMutante();
            String arquivoMutante = "resultadoMutante_" + i + ".txt";
            DAOMutantes daoResMut = new DAO.DAOMutantes();
            daoResMut.testarMutantes(sqlMutante, arquivoMutante);
            
            try {
                /**
                 * Executa o md5deep para o resultadoMutante_i.txt
                 */
                ProcessBuilder pbm = new ProcessBuilder("md5deep", "-q", "/tmp/Resultados/" + arquivoMutante, "-W", "md5Mutante_" + i + ".txt");
                pbm.redirectErrorStream(true);
                Process pm = pbm.start();
                pm.waitFor();
                pm.destroy();
                
            } catch (IOException | InterruptedException ex) {
                System.out.println("md5sum: " + ex.getMessage());
            }
        }
        return listaMutantes;
    }
    
    public double escoreMutacao(ArrayList<Mutante> listaMutantes){
        double mutantesMortos = 0;
        double mutantesVivos = 0;
        NumberFormat doubleFormat = NumberFormat.getInstance();
        doubleFormat.setMaximumFractionDigits(4);
                
        for (int i = 0; i < listaMutantes.size(); i++) {
            try {
                /**
                 * le resultado do md5Original.txt
                 */
                BufferedReader brOrig = new BufferedReader(new FileReader("md5Original.txt"));
                String md5Original = brOrig.readLine();
                //System.out.println("md5Original = " + md5Original);
                brOrig.close();
                /**
                 * le resultado do md5Mutante_i.txt
                 */
                BufferedReader brMutante = new BufferedReader(new FileReader("md5Mutante_"+i+".txt"));
                String md5Mutante = brMutante.readLine();
                //System.out.println("md5Mutante " + i + " = " + md5Mutante);
                brMutante.close();
                /**
                 * compara resultado dos hash md5 
                 * Verifica mutantes mortos e vivos
                 */
                if (md5Original.equals(md5Mutante)){                    
                    mutantesVivos++;
                    //registrarLog("SQL Mutante "+ i +" vivo: " + listaMutantes.get(i).getComando());
                } else{
                    mutantesMortos++;
                }

            } catch (IOException ex) {
                    System.out.println("md5sum: " + ex.getMessage());
            }
        }
        registrarLog("Total de mutantes: "+ listaMutantes.size());      
        registrarLog("Mutantes mortos: " + mutantesMortos);
        registrarLog("Mutantes vivos: " + mutantesVivos);
        
        double escore = (mutantesMortos / listaMutantes.size());
        registrarLog("Escore: "+ doubleFormat.format(escore));
        
        
        return escore;
    }
        
}