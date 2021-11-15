package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Aventura.escenas;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws JAXBException {


        boolean finPartida = false;
        int codigo = 1;

        imprimirCabecera();


        ArrayList<Escena> escenas = LeerXML("C:\\Users\\FP\\Desktop\\aventura.xml");

        while (!finPartida) {
            System.out.println(codigo);
            Escena escenaAct = imprimirEscena(escenas, codigo);
            if (!finPartida) {
                boolean opcionEncontrada = false;

                Scanner scanner = new Scanner(System.in);
                System.out.println("Elija opcion");
                try {
                    int opcionSel = scanner.nextInt();

                    for (Opcion opcion : escenaAct.getOpciones()) {
                        if (opcion.getId() == opcionSel) ;
                        {
                            codigo = opcion.getResultado();
                            opcionEncontrada = true;
                        }
                    }

                    if (!opcionEncontrada) {
                        System.out.println("OPCION NO ENCONTRADA");

                    }
                } catch (Exception e) {
                    System.out.println("OPCION NO VALIDA");

                }
            }

        }
    }


    private static Escena imprimirEscena(ArrayList<Escena> escenas, int codigo) {

        Escena resultado = new Escena();
        int size = escenas.size();

        for (Escena e : escenas) {
            if (e.getCodigo() == codigo) {
                resultado = e;
                System.out.println(e.getTexto());
                for (Opcion o : e.getOpciones()) {
                    System.out.println(o.getId() + "- " + o.getTexto());
                }
            }
        }
        return resultado;
    }


    public static ArrayList<Escena> LeerXML(String ruta) throws JAXBException {
        File file = new File(ruta);
        ArrayList<Escena> escenas = new ArrayList<Escena>();
        if (file.exists()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Aventura.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Aventura aventura = (Aventura) jaxbUnmarshaller.unmarshal(file);
            escenas = (aventura != null ? aventura.getEscenas() : new ArrayList<Escena>());
        } else {
            System.out.println("No se ha podido encontrar el fichero indicado");

        }
        System.out.println(escenas);
        return escenas;
    }


    public static void imprimirCabecera() {
        System.out.println("Bienvenido a AVENTURA, para avanzar elija la opcion deseada y pulse ENTER! ");
    }

}
