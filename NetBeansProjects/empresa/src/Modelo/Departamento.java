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
public class Departamento {
    private int dnumber;
    private String dname;
    private int mgrssn;
    private Date mgrstartdate;
    
    
    public int getDnumber() {
        return dnumber;
    }

    public void setDnumber(int dnumber) {
        this.dnumber = dnumber;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getMgrssn() {
        return mgrssn;
    }

    public void setMgrssn(int mgrssn) {
        this.mgrssn = mgrssn;
    }

    public Date getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(Date mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }
    
}
