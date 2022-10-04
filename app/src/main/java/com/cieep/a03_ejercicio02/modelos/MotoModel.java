package com.cieep.a03_ejercicio02.modelos;

import java.io.Serializable;

public class MotoModel implements Serializable {

    private String marca;
    private String modelo;
    private int cc;

    public MotoModel(String marca, String modelo, int cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.cc = cc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
}
