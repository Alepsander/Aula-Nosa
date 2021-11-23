package org.example;

import org.example.dao.MarcaDaoSQLServer;
import org.example.model.Marca;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MarcaDaoSQLServer marcaDaoSQLServer = new MarcaDaoSQLServer();

        //marcaDaoSQLServer.listar();

        marcaDaoSQLServer.consultar(1);

        marcaDaoSQLServer.eliminar(1);

       // marcaDaoSQLServer.insertar(new Marca(8,"Alex"));

        //marcaDaoSQLServer.actualizar(new Marca(8, "Dani"));
    }
}
