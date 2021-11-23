package org.example;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        int caracter;
        String liner = null;
        int exitVal;

        //Se crea el objeto process
        Process p = new ProcessBuilder("CMD","/C", "DIR").start();

        //Se recogen los datos del proceso mediante un IS
        InputStream is = p.getInputStream();
        while ((caracter = is.read()) != -1){
            System.out.println((char) caracter);
        }
        is.close();

        try{
            exitVal = p.waitFor();
            System.out.println("Valor de salida:" + p.exitValue());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
