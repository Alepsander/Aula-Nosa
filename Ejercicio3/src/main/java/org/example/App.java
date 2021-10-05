package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        File archivolectura = new File("C:\\Users\\FP\\Desktop\\Fichero de pruebas.txt");

        FileInputStream in = null;
        try {
            in = new FileInputStream(archivolectura);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int almacen = in.read();
        String decimales = "";
        String hexadecimales = "";
        String salChar = new String("");

        while (almacen != -1) {
            decimales = decimales + almacen + "-";


            String hexadecimal = Integer.toHexString(almacen);
            hexadecimales = hexadecimales + hexadecimal + "-";
            almacen = in.read();

        }

        System.out.println(decimales);
        System.out.println(hexadecimales);
        System.out.println(salChar);
    }
}
