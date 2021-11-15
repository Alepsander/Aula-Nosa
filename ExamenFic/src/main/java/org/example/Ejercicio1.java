package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Ejercicio1 {



    public static void main( String[] args )
    {

        //leerFicUTF8();
        //escribirFicUTF8(lineas, "C:\\Users\\FP\\Desktop\\Ejercicio1.txt");

        ArrayList<String> listaStrings = new ArrayList<>();

    }



    private static void escribirFicUTF8(ArrayList<String> lineas,String ruta){


        String rutaUTF8 = "C:\\Users\\FP\\Desktop\\Ejercicio1.txt";

        try {
             FileOutputStream fos = null;
             OutputStreamWriter osw = null;

             fos = new FileOutputStream(rutaUTF8);
             osw = new OutputStreamWriter(fos, Charset.forName("ISO-8859-1"));

            int bufferSize = 8*1024;
           // Writer writer = new BufferedWriter(osw(fos(),"UTF-8"), bufferSize);




    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }


    private static void leerFicUTF8(String ruta){

        String rutaUTF8 = "C:\\Users\\FP\\Desktop\\Ejercicio1.txt";

        FileInputStream fis = null;
        InputStreamReader isr = null;

        try {
            fis= new FileInputStream(rutaUTF8);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            int data = isr.read();

            while(data != -1){
                char character = (char) data;
                System.out.println(character);
                data = isr.read();
            }
            System.out.println("Fichero leido");

        } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
