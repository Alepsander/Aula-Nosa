package org.example.connection;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class ConexionNeodatis {

    private static final String PATH_NEODATIS = "C:\\Users\\FP\\Desktop\\Neodatis.odb";
    private static ODB conexion;

    public ConexionNeodatis(){
        conexion = ODBFactory.open(PATH_NEODATIS);
    }

    public static ODB obtenerConexion(){
        if(conexion == null){
            new ConexionNeodatis();
        }
        return conexion;
    }

    public static void cerrarConexion(){
        if(conexion != null){
            conexion.close();
            conexion = null;
        }
    }
}
