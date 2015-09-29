/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execucao;

import static DAO.DAOInstrucaoOriginal.consultaInstrucao;
import static DAO.DAOInstrucaoOriginal.resultInstrucao;
import static DAO.DAOMutantes.consultaMutantes;
import static DAO.DAOMutantes.resultMutantes;
import Modelo.InstrucaoOriginal;
import Modelo.Mutantes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author ludmila
 */
public class TesteMutacao {
        
    public float compararResultados(){
        
        int idInstOriginal = 17;
        boolean result = false;
        String sql, sql2 = "";
        float escore = 0;
        float mutantemorto = 0;
        float mutantevivo = 0;
        String original = "";
        String mutante = "";
        
        InstrucaoOriginal instOrig = new InstrucaoOriginal();
        ArrayList<Mutantes> listaMutantes = new ArrayList<Mutantes>();
        
        listaMutantes = consultaMutantes(idInstOriginal);
        instOrig = consultaInstrucao(idInstOriginal);
        sql = instOrig.getComando();
                    
        for(int i = 0; i < listaMutantes.size(); i++){
            
            int countlinhasiguais = 0;
            int countlinhasdiferentes = 0;
            int countTotal = 0;
                        
            resultInstrucao(sql);
            sql2 = listaMutantes.get(i).getSqlMutante();
            resultMutantes(sql2);
                        
            try {
                BufferedReader brOriginal = new BufferedReader(new FileReader("resultadoOriginal.txt"));
                BufferedReader brMutante = new BufferedReader(new FileReader("resultadoMutante.txt"));
                    		
    		while ((brOriginal.readLine() != null) || (brMutante.readLine() != null))  {
                                        
                    original=brOriginal.readLine();
                    mutante=brMutante.readLine();
                    
                    countTotal++;
                    
                    if (original.equals(mutante)){ 
                        countlinhasiguais ++;
                    
                    }else{
                        countlinhasdiferentes ++;
                    }
    		}
                brOriginal.close();
	    	brMutante.close(); 
                
                System.out.println("totalde linhas: "+countTotal+" linhasiguais: "+countlinhasiguais+" linhasdiferentes: "+countlinhasdiferentes);
    	                       
            } catch (FileNotFoundException ex) {
                System.out.println("readFile: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
            
            if (countlinhasiguais == countTotal){
                mutantemorto++;
            }else{
                mutantevivo++;
            }
        }
         
        System.out.println("mutantes mortos: " + mutantemorto + " mutantes vivos: "+ mutantevivo);
        escore = (mutantemorto /listaMutantes.size()) ;
        System.out.println("escore: " + escore);
        
        return escore;
    }
}