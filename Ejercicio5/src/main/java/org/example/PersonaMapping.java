package org.example;

import java.io.*;
import java.util.ArrayList;

public class PersonaMapping {

public static void escribirPersonas(){


        Persona persona1 = new Persona("Alex", "Castañeda Rivera", "31/1/2000");
        Persona persona2 = new Persona("Dani", "Ares Cabo", "19/4/1999");
        Persona persona3 = new Persona("Jorge", "Vazquez Torres", "26/6/1990");

        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);


        FileOutputStream fos = null;
        ObjectOutputStream oos = null;



    //Metodo de escritura
    try{
         fos = new FileOutputStream("C:\\Users\\FP\\Desktop\\ListaPersonas.txt");

         oos = new ObjectOutputStream(fos);

         oos.writeObject(persona1);
         oos.writeObject(persona2);
         oos.writeObject(persona3);


} catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (fos != null) fos.close();
            if (oos != null) oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


public static void leerPersonas(){

    //Metodo de lectura
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    try {
        fis = new FileInputStream("C:\\Users\\FP\\Desktop\\ListaPersonas.txt");
        ois = new ObjectInputStream(fis);

        Persona obj =(Persona) ois.readObject();

        System.out.println("Se ha leido el objeto del fichero " + obj.getNombre() + " "+ obj.getApellidos() + " " + obj.getFechNacimiento());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }finally {
        try {
            if (fis != null) fis.close();
            if (ois != null) ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
