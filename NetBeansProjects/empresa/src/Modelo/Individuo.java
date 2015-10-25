/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author ludmila
 */
public class Individuo {
    
    private ArrayList<Gene> listaGenes = new ArrayList<Gene>();

    public ArrayList<Gene> getListaGenes() {
        return listaGenes;
    }

    public void setListaGenes(ArrayList<Gene> listaGenes) {
        this.listaGenes = listaGenes;
    }

    public void addGene(Gene gene) {
        listaGenes.add(gene);
    }
    
    public boolean estaVazio(){
        boolean retorno = listaGenes.isEmpty();
        return retorno;
    }
    
    public int tamanho(){
        int retorno = listaGenes.size();
        return retorno;
    }   
}