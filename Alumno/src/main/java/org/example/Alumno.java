package org.example;

public class Alumno {

   private String Nombre;
   private int Edad;
   private double NotaMedia;

    public Alumno() {
    }

    public Alumno(String nombre, int edad, double notaMedia) {
        Nombre = nombre;
        Edad = edad;
        NotaMedia = notaMedia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public double getNotaMedia() {
        return NotaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        NotaMedia = notaMedia;
    }
}
