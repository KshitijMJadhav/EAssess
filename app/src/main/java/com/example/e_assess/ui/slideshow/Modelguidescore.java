package com.example.e_assess.ui.slideshow;

public class Modelguidescore {
    String ISE1,ISE2,MSE,ESE,NAME;

    public Modelguidescore(String ISE1, String ISE2, String MSE, String ESE, String NAME) {
        this.ISE1 = ISE1;
        this.ISE2 = ISE2;
        this.MSE = MSE;
        this.ESE = ESE;
        this.NAME = NAME;
    }

    public String getISE1() {
        return ISE1;
    }

    public void setISE1(String ISE1) {
        this.ISE1 = ISE1;
    }

    public String getISE2() {
        return ISE2;
    }

    public void setISE2(String ISE2) {
        this.ISE2 = ISE2;
    }

    public String getMSE() {
        return MSE;
    }

    public void setMSE(String MSE) {
        this.MSE = MSE;
    }

    public String getESE() {
        return ESE;
    }

    public void setESE(String ESE) {
        this.ESE = ESE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}

