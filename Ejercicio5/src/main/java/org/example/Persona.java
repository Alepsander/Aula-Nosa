package org.example;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private String apellidos;
    private String fechNacimiento;

    public Persona(String alex, String s){
    }

    public Persona(String nombre, String apellidos, String fechNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechNacimiento = fechNacimiento;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechNacimiento() {
        return fechNacimiento;
    }

    public void setFechNacimiento(String fechNacimiento) {
        this.fechNacimiento = fechNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechNacimiento='" + fechNacimiento + '\'' +
                '}';
    }
}