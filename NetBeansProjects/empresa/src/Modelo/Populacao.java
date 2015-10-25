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
public class Populacao {
    
    private int tamanhoPopulacao;
    private ArrayList<Individuo> listaIndividuos;
    
    public Populacao(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.listaIndividuos = new ArrayList<Individuo>(tamanhoPopulacao);
    }

    public ArrayList<Individuo> getListaIndividuos() {
        return listaIndividuos;
    }

    public void setListaIndividuos(ArrayList<Individuo> listaIndividuos) {
        this.listaIndividuos = listaIndividuos;
    }
    
}
