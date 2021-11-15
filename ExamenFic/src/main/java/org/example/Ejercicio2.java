package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.ArrayList;

public class Ejercicio2 {

    public static void main( String[] args )
    {
        ejercicioSAX();
       }


    public static void ejercicioSAX(){

        try{
            XMLReader lector = XMLReaderFactory.createXMLReader();
            ParseadorCiudadesSAX parseador = new ParseadorCiudadesSAX();
            lector.setContentHandler(parseador);
            InputSource fichero = new InputSource(ruta);
            lector.parse(fichero);
            ArrayList<Ciudad> lista = parseador.obtenerResultados();
            System.out.println(lista);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
