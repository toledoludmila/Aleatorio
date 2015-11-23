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
public class Mutante {
    private int id;
    private String categoria;
    private String tipo;
    private String sqlMutante;
    private int idInstrucao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSqlMutante() {
        return sqlMutante;
    }

    public void setSqlMutante(String sqlMutante) {
        this.sqlMutante = sqlMutante;
    }
    
    public int getIdInstrucao() {
        return idInstrucao;
    }

    public void setIdInstrucao(int idInstrucao) {
        this.idInstrucao = idInstrucao;
    }
 
}
