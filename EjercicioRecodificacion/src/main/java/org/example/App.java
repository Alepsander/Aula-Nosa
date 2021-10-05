package org.example;

import java.io.*;

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
            isr = new InputStreamReader(fis);

            fos = new FileOutputStream("C:\\Users\\FP\\Desktop\\FicheroCodificacion.txt");
            osw = new OutputStreamWriter(fos);

            int car = fis.read();

            while (car != -1) {
                fos.write(car);
                car = fis.read();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    }
}