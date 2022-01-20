package org.example.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class Festival {

    private int Id;
    private String Nombre;
    private String Descripcion;
    private Timestamp Inicio;
    private Timestamp Fin;
    private int Aforo;
    private double Precio;
    private int Ventas;

    public Festival() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Timestamp getInicio() {
        return Inicio;
    }

    public void setInicio(Timestamp inicio) {
        Inicio = inicio;
    }

    public Timestamp getFin() {
        return Fin;
    }

    public void setFin(Timestamp fin) {
        Fin = fin;
    }

    public int getAforo() {
        return Aforo;
    }

    public void setAforo(int aforo) {
        Aforo = aforo;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getVentas() {
        return Ventas;
    }

    public void setVentas(int ventas) {
        Ventas = ventas;
    }

    public Festival(int id, String nombre, String descripcion, Timestamp inicio, Timestamp fin, int aforo, double precio, int ventas) {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Inicio = inicio;
        Fin = fin;
        Aforo = aforo;
        Precio = precio;
        Ventas = ventas;
    }



    @Override
    public String toString() {
        return "Festival{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Inicio=" + Inicio +
                ", Fin=" + Fin +
                ", Aforo=" + Aforo +
                ", Precio=" + Precio +
                ", Ventas=" + Ventas +
                '}';
    }
}
