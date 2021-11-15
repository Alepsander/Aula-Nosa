package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Locale;

public class ParseadorCiudadesSAX extends DefaultHandler {

    private ArrayList<Ciudad> listado;
    private Ciudad ciudad;
    private String poblacion;
    private String comunidad;

    enum tipoNodos{
        CIUDADES,
        CIUDAD,
        POBLACION,
        COMUNIDAD
    }

    @Override
    public ParseadorCiudadesSAX{
        super();
    }

    @Override
    public void startDocument() throws SAXException{
        listado = new ArrayList<Ciudad>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atributes) throws SAXException{
        if (localName!=null){
            switch (tipoNodos.valueOf(localName.toUpperCase(Locale.ROOT))){
                case CIUDAD:
                    ciudad = new Ciudad();
                    String nombre=atributes.getValue("Nombre");
                    if(nombre!=null){
                        ciudad.setNombre(nombre);

                    }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(localName!=null){
            switch (tipoNodos.valueOf(localName.toUpperCase())){
                case CIUDAD:
                    listado.add(ciudad);
                    break;
                case POBLACION:
                    listado.add(poblacion);
                    break;
                case COMUNIDAD:
                    listado.add(comunidad);
                    break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        valorElemento = new String(ch,start,length);
    }

    public ArrayList<Ciudad> obtenerResultados(){
        return listado
    }


}
