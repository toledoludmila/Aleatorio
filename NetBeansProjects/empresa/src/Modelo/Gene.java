/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ludmila
 */
public class Gene {
    
    private int tabela;
    private int tupla;
    
    public Gene () {
    }
    
    public Gene (int tabela, int tupla) {
        this.tabela = tabela;
        this.tupla = tupla;
    }
        
    public int getTabela() {
        return tabela;
    }

    public void setTabela(int tabela) {
        this.tabela = tabela;
    }

    public int getTupla() {
        return tupla;
    }

    public void setTupla(int tupla) {
        this.tupla = tupla;
    }
    
}