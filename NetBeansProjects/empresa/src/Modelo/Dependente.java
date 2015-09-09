/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author ludmila
 */
public class Dependente {
    private int essn;
    private String dependent_name;
    private String sex;
    private Date dbate;
    private String relationship;
    private int id;
    

    public int getEssn() {
        return essn;
    }

    public void setEssn(int essn) {
        this.essn = essn;
    }

    public String getDependent_name() {
        return dependent_name;
    }

    public void setDependent_name(String dependent_name) {
        this.dependent_name = dependent_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDbate() {
        return dbate;
    }

    public void setDbate(Date dbate) {
        this.dbate = dbate;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
