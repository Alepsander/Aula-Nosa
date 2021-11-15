import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ejercicio2 {

    public static void main( String[] args )
    {
        realizarLecturaXML();
    }


    private static void realizarLecturaXML(){

        File file = new File("C:\\Users\\FP\\Desktop\\Ejercicio2.xml");
        ArrayList<Rios> rios = new ArrayList<Rios>();
        if (file.exists()){
            JAXBContext jaxbContext = null;

            try {
                jaxbContext = JAXBContext.newInstance(ListaRios.class);
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            Unmarshaller jaxbUnmarshaller = null;
            try {
                jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            ListaRios listaRios = null;

            try {
                listaRios = (ListaRios) jaxbUnmarshaller.unmarshal(file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            rios = (listaRios !=null ? listaRios.getListaRios() : new ArrayList<Rios>());

            for (Rios r : rios) {
                System.out.println(r.toString());
            }
        }
    }

    private static void realizarGuardadoXML() throws JAXBException, IOException{
        File file = new File("C:\\Users\\FP\\Desktop\\Ejercicio2.xml");

        if (file.exists()){
            file.createNewFile();
        }

        ArrayList<Rios> rios = new ArrayList<Rios>();
        JAXBContext jaxbContext = JAXBContext.newInstance(ListaRios.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        ListaRios lr = new ListaRios();
        lr.setListaRios(rios);
        jaxbMarshaller.marshal(lr,file);

        System.out.println("Fichero guardado");


    }

}
