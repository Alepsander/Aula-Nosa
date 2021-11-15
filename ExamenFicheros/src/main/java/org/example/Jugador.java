package org.example;

public class Jugador {

    private String nombre;
    private int goles;
    private int partidos;

    public Jugador() {
    }

    public Jugador(String nombre, int goles, int partidos) {
        this.nombre = nombre;
        this.goles = goles;
        this.partidos = partidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", goles=" + goles +
                ", partidos=" + partidos +
                '}';
    }
}
