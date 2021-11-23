package org.example.dao;

import org.example.connection.ConexionSQLServer;
import org.example.model.Heroe;

import java.sql.*;

import static org.example.connection.ConexionSQLServer.obtenerConexion;

public class HeroeDAOSQLServer implements HeroeDAO {

    @Override
    public void insertar(Heroe objeto) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "INSERT INTO Heroes"
                    + "(Nombre, Clase, Raza) VALUES"
                    + "(?,?,?);";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
            ps.setString(2,objeto.getClase());
            ps.setString(3,objeto.getRaza());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la consola");
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
    }


    @Override
    public void actualizar(Heroe objeto) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "UPDATE Heroes SET nombre = ?, clase = ?, raza = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
            ps.setString(2,(objeto.getClase()));
            ps.setString(3,(objeto.getRaza()));
            ps.setInt(4, (objeto.getId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la consola");
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
    }


    @Override
    public void eliminar(int id){
        PreparedStatement sentencia = null;

        try{
            String sql= "DELETE FROM Heroes WHERE id = ?";
            sentencia = obtenerConexion().prepareStatement(sql);
            sentencia.setInt(1,id);
            sentencia.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (sentencia!=null) sentencia.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
