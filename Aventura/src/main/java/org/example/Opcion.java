package org.example;

import javax.xml.bind.annotation.XmlAttribute;

public class Opcion {
    private int id;
    private String texto;
    private String resultado;

    public Opcion(int id, String texto, String resultado) {
        this.id = id;
        this.texto = texto;
        this.resultado = resultado;
    }

    public Opcion() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    @XmlAttribute
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getResultado() {
        return Integer.parseInt(resultado);
    }

    @XmlAttribute
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Opcion{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
