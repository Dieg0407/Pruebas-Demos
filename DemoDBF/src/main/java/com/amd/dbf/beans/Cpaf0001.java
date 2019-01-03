package com.amd.dbf.beans;

/**
 * Esta clase representa un registro en la tabla CPAF0001
 */
public class Cpaf0001 {
    private String desCon;
    private String varCon;
    private String dbfCon;

    public Cpaf0001(){}


    public String getDesCon() {
        return desCon;
    }

    public void setDesCon(String desCon) {
        this.desCon = desCon;
    }

    public String getVarCon() {
        return varCon;
    }

    public void setVarCon(String varCon) {
        this.varCon = varCon;
    }

    public String getDbfCon() {
        return dbfCon;
    }

    public void setDbfCon(String dbfCon) {
        this.dbfCon = dbfCon;
    }

    @Override
    public String toString() {
        return "Cpaf0001{" +
                "desCon='" + desCon + '\'' +
                ", varCon='" + varCon + '\'' +
                ", dbfCon='" + dbfCon + '\'' +
                '}';
    }
}
