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
    
    private ArrayList<Gene> listaIndividuo = new ArrayList<Gene>();

    public ArrayList<Gene> getListaIndividuo() {
        return listaIndividuo;
    }

    public void setListaIndividuo(ArrayList<Gene> listaIndividuo) {
        this.listaIndividuo = listaIndividuo;
    }
   
}