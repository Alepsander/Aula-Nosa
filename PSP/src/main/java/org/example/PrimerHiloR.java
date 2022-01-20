package org.example;

import static java.lang.Thread.currentThread;

public class PrimerHiloR implements Runnable{

    @Override
    public void run() {

    }

    public static class UsarPrimerHiloR{
        public static void main (String [] args){
            PrimerHiloR hilo1 = new PrimerHiloR();
            new Thread(hilo1).start();

            PrimerHiloR hilo2 = new PrimerHiloR();
            Thread hilo = new Thread(hilo2);
            hilo.start();

            new Thread(new PrimerHiloR()).start();
        }
    }
}
