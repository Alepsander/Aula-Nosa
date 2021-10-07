package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main( String[] args ){

        Alumno alumno1 = new Alumno("Alex", 21, 7);
        Alumno alumno2= new Alumno("Dani", 22, 8);
        Alumno alumno3 = new Alumno("Dario", 23, 9.5);

        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);



            RandomAccessFile raf = null;

            //Random access file escritura
            try {
                raf = new RandomAccessFile("C:\\Users\\FP\\Desktop\\ListaAlumnos.txt", "rw");
            //raf.seek(1);
            for (Alumno obj: listaAlumnos) {
                raf.writeChars(obj.getNombre());
                raf.writeChars(String.valueOf(obj.getEdad()));
                raf.writeChars(String.valueOf(obj.getNotaMedia()));
            }


            //Random access file lectura
            raf.seek(2);
            byte[] bytes = new byte[60];
            raf.read(bytes);
            System.out.println(new String(bytes));


                raf.close();


            } catch (FileNotFoundException e) {
                    e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
