package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class Ejercicio3 {

    public static void main( String[] args )
    {
        leerJSON();
    }

    private static void leerJSON() {
        try{
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Jugador> lista = mapper.readValue(new File("C:\\Users\\FP\\Desktop\\Ejercicio3.JSON"),
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Jugador.class));

            for (Jugador m : lista) {
                System.out.println(m.getNombre() + "+" + m.getGoles() + "+" + m.getPartidos());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

