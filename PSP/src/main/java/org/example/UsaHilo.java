package org.example;

public class UsaHilo {

    public static void main(String[] args){
        Hilos h1 = new Hilos("Jomer");
        Hilos h2 = new Hilos("Lleti");
        Hilos h3 = new Hilos("Hall");

        h1.start();
        h2.start();
        h3.start();

        System.out.println("3 hilos lanzados");
    }
}
