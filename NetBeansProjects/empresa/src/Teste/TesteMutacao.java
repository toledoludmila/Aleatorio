/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import static DAO.DAOInstrucaoOriginal.consultaInstrucao;
import static DAO.DAOInstrucaoOriginal.resultInstrucao;
import static DAO.DAOMutantes.consultaMutantes;
import static DAO.DAOMutantes.resultMutantes;
import Modelo.InstrucaoOriginal;
import Modelo.Mutantes;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ludmila
 */
public class TesteMutacao {
    
    public static void testar(){
    
        int idInstOriginal = 17;
        int countequivalente = 0;
        int countmorto = 0;
        boolean result;
        String sql, sql2 = "";
        ResultSet resultado1,resultado2;
                
        InstrucaoOriginal instOrig = new InstrucaoOriginal();
        ArrayList<Mutantes> listaMutantes = new ArrayList<Mutantes>();
        
        listaMutantes = consultaMutantes(idInstOriginal);
        instOrig = consultaInstrucao(idInstOriginal);
        sql = instOrig.getComando();
                    
        for(int i = 0; i < listaMutantes.size(); i++){
            
            resultado1 = resultInstrucao(sql);
            sql2 = listaMutantes.get(i).getSqlMutante();
            resultado2 = resultMutantes(sql2);
            
            result = compararResultSets(resultado1,resultado2);
            
            if (result == true){
                countequivalente++;
                System.out.println("contador equivalente:" + countequivalente);
            }else{
                countmorto++;
                System.out.println("contador morto:" + countmorto);
            }
        }
        
        int escore = countmorto / (listaMutantes.size() - countequivalente);
        System.out.println("Escore de mutacao: " + escore);
    }
    
    public static boolean compararResultSets(ResultSet resultSet1, ResultSet resultSet2){
        
        
        try {
            while (resultSet1.next()) {
                
                resultSet2.next();
                ResultSetMetaData resultSetMetaData = resultSet1.getMetaData();
                int count = resultSetMetaData.getColumnCount();
                
                for (int i = 1; i <= count; i++) {
                
                    if (!resultSet1.getObject(i).equals(resultSet2.getObject(i))) {
                
                        System.out.println("resultado diferente");
                        return false;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("comparar resultsets: " + ex.getMessage());
        }
        return true;
    }
}
