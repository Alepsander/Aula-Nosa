package org.example;

import java.io.*;
import java.text.FieldPosition;

public class App
{
    public static void main( String[] args ) throws IOException {
        File archivoorigen = new File("C:\\Users\\FP\\Desktop\\ArchivoOrigen.txt");
        File archivodestino = new File("C:\\Users\\FP\\Desktop\\ArchivoDestino.txt");

        FileInputStream in = null;
        try {
            in = new FileInputStream(archivoorigen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(archivodestino);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int almacen = in.read();

        while ( almacen != -1){
            out.write(almacen);
            almacen = in.read();
        }

        in.close();
        out.close();

    }

}