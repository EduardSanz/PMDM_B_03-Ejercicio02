package com.cieep.a03_ejercicio02.modelos;

import java.io.Serializable;

public class BiciModel implements Serializable {

    private String marca;
    private int pulgadas;

    public BiciModel(String marca, int pulgadas) {
        this.marca = marca;
        this.pulgadas = pulgadas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }
}
