package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class Festival implements Serializable {

    private int Id;

    public Set<Actuacion> getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(Set<Actuacion> actuaciones) {
        this.actuaciones = actuaciones;
    }

    private String Nombre;
    private String Descripcion;
    private Timestamp Inicio;
    private Timestamp Fin;
    private int Aforo;
    private double Precio;
    private int Ventas;
    private Set<Actuacion> actuaciones;

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

    //Constructor con set
    public Festival(int id, String nombre, String descripcion, Timestamp inicio, Timestamp fin, int aforo, double precio, int ventas, Set<Actuacion> actuaciones) {
        Id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Inicio = inicio;
        Fin = fin;
        Aforo = aforo;
        Precio = precio;
        Ventas = ventas;
        this.actuaciones = actuaciones;
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
