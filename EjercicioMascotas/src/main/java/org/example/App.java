package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        //ObtenerMascotas.LecturaDOM();
        //ObtenerMascotas.EscrituraDOM();

        try{
            XMLReader lector = XMLReaderFactory.createXMLReader();
            ParseadorMascotasSAX parser = new ParseadorMascotasSAX();
            lector.setContentHandler(parser);
            InputSource fichero = new InputSource("C:\\Users\\FP\\Desktop\\mascotas.xml");
            lector.parse(fichero);
            ArrayList<Mascota> lista = parser.obtenerResultado();
            System.out.println(lista);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

}
