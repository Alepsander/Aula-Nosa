package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name="mascotas")
public class ListaMascotasJAXB {
        private ArrayList<MascotasJAXB> listaMascotas;

        public void setListaMascotas(ArrayList<MascotasJAXB> listaMascotas){
            this.listaMascotas = listaMascotas;
        }

        @XmlElement(name="mascota")
        public ArrayList<MascotasJAXB> getListaMascotas(){
            return this.listaMascotas;
        }
    }
