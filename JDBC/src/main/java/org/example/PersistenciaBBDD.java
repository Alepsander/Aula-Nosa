package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenciaBBDD {

   // private void CargarDriver() throws ClassNotFoundException{
     //   Class.forName("");
    //}

public static Connection obtenerConexion() throws SQLException{
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Tienda";
        String usuario = "sa";
        String pass = "facebook";
    Connection c = DriverManager.getConnection(url,usuario,pass);
    return c;
}
}
