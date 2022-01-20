package org.example.model;

import org.example.dao.RioDAOSQLServer;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RioDAOSQLServer rioDAOSQLServer = new RioDAOSQLServer();
        Rio objRio = new Rio(5, "Waterfall", 920, 2043);


        ArrayList<Rio> listaRios = new ArrayList<>();
        listaRios.add(new Rio(15, "Rio Random",1233 ,3123 ));
        listaRios.add(new Rio(15, "Riverdale",1312 ,6456 ));
        listaRios.add(new Rio(15, "Bamboleos",345 ,983 ));



        rioDAOSQLServer.insertar(new Rio(1004, "Wattson", 321, 3123));
        System.out.println("Rio insertado con exito");
        System.out.println("--------------------------------------------------------------------");


        rioDAOSQLServer.consultar(1004);
        System.out.println("Consulta realizada con exito");
        System.out.println("--------------------------------------------------------------------");


        rioDAOSQLServer.actualizar(new Rio(1004,"Rio de lava",1020 ,800 ));
        System.out.println("Rio actualizado con exito");
        System.out.println("--------------------------------------------------------------------");


        rioDAOSQLServer.consultar(1004);
        System.out.println("Consulta realizada con exito");
        System.out.println("--------------------------------------------------------------------");



        rioDAOSQLServer.eliminar(1004);
        System.out.println("Rio eliminado con exito");


        /*
        rioDAOSQLServer.listarVista();
        System.out.println("Lista consultada con exito");
        */


        /*
        rioDAOSQLServer.listarSP();
        System.out.println("Procedimiento listado con exito");
        */


        /*
        rioDAOSQLServer.insertarRiosLotes(listaRios);
        System.out.println("Conjunto de elementos insertados con exito");
        */

    }
}
