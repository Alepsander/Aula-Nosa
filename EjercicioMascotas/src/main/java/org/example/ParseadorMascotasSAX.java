package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ParseadorMascotasSAX extends DefaultHandler {
    private ArrayList<Mascota> listado;
    private Mascota mascota;
    private String valorElemento;


    enum tiposNodo {
        MASCOTAS,
        MASCOTA,
        NOMBRE,
        TIPO,
        EDAD,
        GENERO
    }

    public ParseadorMascotasSAX() {
        super();
    }

    public void startDocument() {
        listado = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (localName != null) {
            switch (tiposNodo.valueOf(localName.toUpperCase())) {
                case MASCOTA:
                    mascota = new Mascota();
                    String nombre = attributes.getValue("Nombre");
                    if (nombre != null) {
                        mascota.setNombre(nombre);
                    }
                    break;
            }
        }
    }

    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException {
            if (localName != null) {
                switch (tiposNodo.valueOf(localName.toUpperCase())) {
                    case MASCOTAS:
                        break;
                    case MASCOTA:
                        listado.add(mascota);
                        break;
                    case NOMBRE:
                        mascota.setNombre(valorElemento);
                        break;
                    case TIPO:
                        mascota.setTipo(valorElemento);
                    case EDAD:
                        mascota.setEdad(valorElemento);
                        break;
                    case GENERO:
                        mascota.setGenero(valorElemento);
                }
            }
        }

        @Override
        public void characters ( char[] ch, int start, int lenght) {
            valorElemento = new String(ch, start, lenght);
        }

        public ArrayList<Mascota> obtenerResultado () {
            return listado;
        }


    }