package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class MascotasJAXB {

    private String nombre;
    private String tipo;
    private String edad;
    private String genero;

    public MascotasJAXB(String nombre, String tipo, String edad, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.genero = genero;
    }

    public MascotasJAXB() {
    }

    public String getNombre() {
        return nombre;
    }
    @XmlAttribute(name = "Nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }
    @XmlElement
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEdad() {
        return edad;
    }
    @XmlElement
    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }
    @XmlElement
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "MascotasJAXB{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", edad='" + edad + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
