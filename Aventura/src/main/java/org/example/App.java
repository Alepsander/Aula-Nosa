package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException {

   ArrayList<Escena> escenas = LeerXML("C:\\Users\\FP\\Desktop\\aventura.xml");




    }

    public static ArrayList<Escena> LeerXML(String ruta) throws JAXBException {
        File file = new File(ruta);
        ArrayList<Escena> escenas = new ArrayList<Escena>();
        if (file.exists()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Aventura.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Aventura aventura = (Aventura) jaxbUnmarshaller.unmarshal(file);
            escenas = (aventura !=null ? aventura.getEscenas() : new ArrayList<Escena>());
        } else {
            System.out.println("No se ha podido encontrar el fichero indicado");

        }
        System.out.println(escenas);
        return escenas;
    }


}
