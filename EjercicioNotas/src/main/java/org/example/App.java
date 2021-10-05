package org.example;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        FileInputStream in = null;

        try {
            in = new FileInputStream("C:\\Users\\FP\\Desktop\\notas.txt");


            File archivoNotas = new File("C:\\Users\\FP\\Desktop\\notas.txt");
            FileReader fr = null;

            fr = new FileReader(archivoNotas);

            BufferedReader br = null;
            br = new BufferedReader(fr);


            String almacenNotas = "";

            almacenNotas = br.readLine();


            String notas = "";

            while (almacenNotas != null) {
                notas = notas + almacenNotas;
                almacenNotas = br.readLine();

            }


            String []mediaNotas = notas.toString().split("[|]");
            double media = 0.0;

            for (String nota:mediaNotas){
                media +=Double.parseDouble(nota);
            }

            media = media/ mediaNotas.length;



            System.out.println(media);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}