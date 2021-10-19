package org.example;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ObtenerMascotas {

    public static void LecturaDOM() {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse("C:\\Users\\FP\\Desktop\\mascotas.xml");

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("mascota");
            ArrayList<Mascota> listaMascotas = new ArrayList<>();
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nNode;
                    String valorNombre = elem.getAttribute("Nombre");
                    Node tipo = elem.getElementsByTagName("tipo").item(0);
                    String valorTipo = tipo.getNodeValue();
                    Node edad = elem.getElementsByTagName("edad").item(0);
                    String valorEdad = edad.getNodeValue();
                    Node genero = elem.getElementsByTagName("genero").item(0);
                    String valorGenero = edad.getNodeValue();

                    Mascota mascota1 = new Mascota(valorNombre, valorTipo, valorEdad, valorGenero);


                    listaMascotas.add(mascota1);


                }
            }

            for (Mascota mascota : listaMascotas) {
                System.out.println(mascota.getNombre());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void EscrituraDOM() {
        try {
            ArrayList<Mascota> listaMascotas = new ArrayList<>();

            listaMascotas.add(new Mascota("Misifu", "Gato", "10", "Macho"));
            listaMascotas.add(new Mascota("Toby", "Perro", "4", "Macho"));
            listaMascotas.add(new Mascota("Kame", "Tortuga", "1", "Hembra"));


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse("C:\\Users\\FP\\Desktop\\mascotas.xml");


            Element eRaiz = doc.createElement("mascotas");
            doc.appendChild(eRaiz);

            for (Mascota obj : listaMascotas) {
                Element mascota = doc.createElement("mascota");
                eRaiz.appendChild(mascota);

                Attr attr = doc.createAttribute("Nombre");
                attr.setNodeValue("Leo");
                mascota.setAttributeNode(attr);

                if (obj.getTipo() != null) {
                    Element eTipo = doc.createElement("tipo");
                    eTipo.appendChild(doc.createTextNode(obj.getTipo()));
                    mascota.appendChild(eTipo);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("C:\\Users\\FP\\Desktop\\mascotas2.xml"));

                transformer.transform(source, result);

            }
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}