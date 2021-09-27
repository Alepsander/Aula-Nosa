package org.example;

public class Coche extends Vehiculo{

    private int numeroRuedas;

    public Coche(int velocidad, int numeroRuedas){
        super(velocidad);
        this.numeroRuedas = numeroRuedas;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }
}
