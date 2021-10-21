package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException, IOException {

        //ObtenerMascotas.LecturaDOM();
        //ObtenerMascotas.EscrituraDOM();
        /*
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
        }*/
    realizarLecturaXML();

    realizarGuardadoXML();


    }
private static void realizarLecturaXML() throws JAXBException {
    File file = new File("C:\\Users\\FP\\Desktop\\mascotas.xml");
    ArrayList<MascotasJAXB> mascotas = new ArrayList<MascotasJAXB>();
    if (file.exists()) {
        JAXBContext jaxbContext = JAXBContext.newInstance(ListaMascotasJAXB.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        ListaMascotasJAXB listaMascotas = (ListaMascotasJAXB) jaxbUnmarshaller.unmarshal(file);
        mascotas = (listaMascotas != null ? listaMascotas.getListaMascotas() : new ArrayList<MascotasJAXB>());

        for (MascotasJAXB m : mascotas) {
            System.out.println(m.toString());
        }
    }
}


private static void realizarGuardadoXML() throws JAXBException, IOException {
        File file = new File("C:\\Users\\FP\\Desktop\\guardadomascotas.xml");

        if (file.exists()) {
            file.createNewFile();
        }

        ArrayList<MascotasJAXB> mascotas = new ArrayList<MascotasJAXB>();
        mascotas.add(new MascotasJAXB("Toby", "Perro", "3", "Macho"));
        JAXBContext jaxbContext = JAXBContext.newInstance(ListaMascotasJAXB.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        ListaMascotasJAXB ma = new ListaMascotasJAXB();
        ma.setListaMascotas(mascotas);
        jaxbMarshaller.marshal(ma,file);

        System.out.println("Fichero guardado");
}
}