package org.example;

import com.sun.xml.internal.bind.v2.TODO;
import org.example.dao.HeroeDAOSQLServer;
import org.example.model.Heroe;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {

        HeroeDAOSQLServer heroeDaoSQLServer = new HeroeDAOSQLServer();
        Heroe objHeroe = new Heroe(14, "Link", "Caballero", "1");

        /*
        heroeDaoSQLServer.insertar(new Heroe(12, "Merlin", "Mago", "1"));
        System.out.println("Heroe insertado con exito");
        */

        /*
        heroeDaoSQLServer.actualizar(new Heroe(11, "Nightingale", "Curandero", "3"));
        System.out.println("Heroe actualizado con exito");
        */

        /*
          heroeDaoSQLServer.eliminar(8);
          System.out.println("Heroe eliminado con exito");
        */

        /*
        heroeDaoSQLServer.Consultar(objHeroe);
        System.out.println("Consulta realizada con exito");
        */

        /*
        heroeDaoSQLServer.Listar();
        System.out.println("Lista realizada con exito");
        */

        //todo Vista, procedimiento almacenado y batch


    }
}