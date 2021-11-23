package org.example.model;

public class Heroe {

    private int id;
    private String nombre;
    private String clase;
    private String raza;

    public Heroe() {
    }

    public Heroe(int id, String nombre, String clase, String raza) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


    @Override
    public String toString() {
        return "Heroe{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
