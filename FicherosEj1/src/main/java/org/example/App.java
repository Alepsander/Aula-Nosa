package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException {


        //Creacion de directorios

        File directorio1 = new File("C:\\Users\\FP\\Desktop\\Ejercicio1\\Directorio1");
        if (!directorio1.exists()) {
            if (directorio1.mkdirs()) {
                System.out.println("Directorio 1 creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }

        File directorio2 = new File("C:\\Users\\FP\\Desktop\\Ejercicio1\\Directorio2");
        if (!directorio2.exists()) {
            if (directorio2.mkdirs()) {
                System.out.println("Directorio 2 creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }

        //------------------------------------------------------------------------------------------------------------------------------------------

        //Creacion de ficheros

            File fichero1 = new File("C:\\Users\\FP\\Desktop\\Ejercicio1\\Directorio1\\fichero1.txt");
        if (!fichero1.exists()) {
            fichero1.createNewFile();
            System.out.println("Se ha creado el fichero 1");
        }else{
            System.out.println("Ya existe " + fichero1.getName());
        }


        File fichero2 = new File("C:\\Users\\FP\\Desktop\\Ejercicio1\\Directorio1\\fichero2.txt");
        if (!fichero2.exists()) {
            fichero2.createNewFile();
            System.out.println("Se ha creado el fichero 2");

        }else{
            System.out.println("Ya existe " + fichero2.getName());
        }

        File fichero3 = new File("C:\\Users\\FP\\Desktop\\Ejercicio1\\Directorio2\\fichero3.txt");
        if (!fichero3.exists()) {
            fichero3.createNewFile();
            System.out.println("Se ha creado el fichero 3");

        }else{
            System.out.println("Ya existe " + fichero3.getName());

        }


        File fichero4 = new File("C:\\Users\\FP\\Desktop\\Ejercicio1\\fichero4.txt");
        if (!fichero4.exists()) {
            fichero4.createNewFile();
            System.out.println("Se ha creado el fichero 4");

        }else{
            System.out.println("Ya existe " + fichero4.getName());

        }
        }

        private static void recorrerFicheros(String "C:\\Users\\FP\\Desktop\\Ejercicio1") {

        File root = new File( "C:\\Users\\FP\\Desktop\\Ejercicio1");
        File[] list = root.listFiles();

        System.out.println("Entrando a la funcion con " + path );

        if (list==null) return;

        for (File f:list) {
            if (f.isDirectory()) {
                System.out.println("Directorio - " + f.getAbsoluteFile());
                recorrerFicheros();(f.getAbsolutePath());
            }
            else{
                System.out.println("Fichero -" + f.getAbsoluteFile());
            }

        }
        }





    }