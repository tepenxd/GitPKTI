package com.example.ryzen.e_hospital;

public class Hospital {
    String Hname;
    String Haddress;
    public Hospital(){

    }

    public Hospital(String hname, String haddress) {
        this.Hname = hname;
        this.Haddress = haddress;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        Hname = hname;
    }

    public String getHaddress() {
        return Haddress;
    }

    public void setHaddress(String haddress) {
        Haddress = haddress;
    }
}
