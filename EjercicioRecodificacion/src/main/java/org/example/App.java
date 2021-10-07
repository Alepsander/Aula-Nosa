package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        InputStreamReader isr = null;

        OutputStreamWriter osw = null;
        FileOutputStream fos = null;


        try {
            fis = new FileInputStream("C:\\Users\\FP\\Desktop\\FicheroCodificacion.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            fos = new FileOutputStream("C:\\Users\\FP\\Desktop\\FicheroCodificacion2.txt");
            osw = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1);

            int data = isr.read();


            while (data != -1) {
                char caracter = (char) data;
                System.out.print(caracter);
                osw.write(caracter);
                data = isr.read();
            }




        isr.close();
        osw.close();
        fis.close();
        fos.close();
        
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
    }