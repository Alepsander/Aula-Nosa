package org.example;

import org.example.dao.HeroeDAOSQLServer;
import org.example.model.Heroe;

import java.sql.*;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {

        HeroeDAOSQLServer heroeDaoSQLServer = new HeroeDAOSQLServer();
        Heroe objHeroe = new Heroe(14, "Link", "Caballero", "1");


        ArrayList<Heroe> listaHeroes = new ArrayList<>();
        listaHeroes.add(new Heroe(15, "Scathach", "Caballero", "1"));
        listaHeroes.add(new Heroe(16, "Jack", "Picaro", "9"));
        listaHeroes.add(new Heroe(17, "Shivana", "Mago", "8"));



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


        HeroeDAOSQLServer.VistaHeroesOrdenAlfabetico();
        System.out.println("Vista realizada con exito");


        /*
        heroeDaoSQLServer.insertarHeroesLotes(listaHeroes);
        System.out.println("Insercion realizada con exito");
        */

/*
        heroeDaoSQLServer.listarHeroesPorRazas();
*/


    }
}