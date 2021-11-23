package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLServer {

    private static final String BD_SERVIDOR = "jdbc:sqlserver://localhost:1433;database=";
    private static final String BD_NOMBRE= "JuegoRol";
    private static final String BD_USUARIO="sa";
    private static final String BD_PASSWORD ="facebook";
    private static Connection conexion;

    public ConexionSQLServer(){

        try{
            conexion = DriverManager.getConnection(BD_SERVIDOR + BD_NOMBRE, BD_USUARIO, BD_PASSWORD);
            System.out.println("Conexion con BBDD realizada");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion(){
        if(conexion == null){
            new ConexionSQLServer();
        }
        return conexion;
    }

    public static void cerrarConexion(){
        if(conexion != null){
            try{
                conexion.close();
                System.out.println("BBDD CERADA");
            }catch (SQLException e){
            System.out.println("ERROR EN LA BBDD");
            e.printStackTrace();
            }
        }
    }

}
