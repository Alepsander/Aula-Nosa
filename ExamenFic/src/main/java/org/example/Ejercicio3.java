package org.example;

import java.io.File;
import java.util.ArrayList;

public class Ejercicio3 {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }




private static void ejercicioJACKSONEsc(){
    ArrayList<Delegado> alumnosLista = new ArrayList<>();

    alumnosLista.add(new Delegado());
    alumnosLista.add(new Delegado());

    try{
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.writerWithinDefaultPrettyPrinter().writeValue)new File(ruta),alumnosLista);

    }catch (Exception e){
        e.printStackTrace();

}
}
