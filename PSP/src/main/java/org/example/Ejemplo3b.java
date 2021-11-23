package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo3b {
    public static void main(String[] args) throws IOException {
        int caracter;
        String liner = null;

        Process p = new ProcessBuilder("CMD", "/C", "DIR").start();

        InputStream is = p.getInputStream();
        while ((caracter = is.read()) != -1){
            System.out.println((char) caracter);
        }
        is.close();

        try{
            InputStream err = p.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(err));
            while ((liner = br.readLine()) != null);
            System.out.println("ERROR >" + liner);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}