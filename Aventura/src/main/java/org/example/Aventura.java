package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;


@XmlRootElement
public class Aventura {
    private String titulo;
   private  ArrayList<Escena> escenas = new ArrayList<>();

    public Aventura(String titulo) {
        this.titulo = titulo;

    }

    public Aventura() {
    }

    public String getTitulo() {
        return titulo;
    }
    @XmlAttribute(name="titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Escena> getEscenas() {
        return this.escenas;
    }
    @XmlElement(name="escena")
    public void setEscenas(ArrayList<Escena> escenas) {
        this.escenas = escenas;
    }

    @Override
    public String toString() {
        return "Aventura{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
