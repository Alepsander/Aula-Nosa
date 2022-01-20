package org.example;

public class Hilos extends Thread{

    public Hilos(String nombre){
        super(nombre);
        System.out.println("Creando hilo" + getName());
    }

    public void run() {
        int cont;
        for (cont = 0; cont < 10; cont++){
            System.out.println("Hilo" + getName() + " " + cont );
        }
        }
    }
