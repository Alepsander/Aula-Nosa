package org.example.dao;

import org.example.connection.ConexionSQLServer;
import org.example.model.Marca;

import java.sql.*;
import java.util.List;

import static org.example.connection.ConexionSQLServer.obtenerConexion;

public class MarcaDaoSQLServer implements MarcaDao {

    public MarcaDaoSQLServer() {
    }


    @Override
    public List<Marca> listar() {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "SELECT NOMBRE FROM MARCAS";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("Nombre"));
            }
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
        return null;
    }



    @Override
    public Marca consultar(int id) {

        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try{
            c = obtenerConexion();
            String consulta = "INSERT INTO MARCAS" + "(NOMBRE) VALUES " + "(?)";
            PreparedStatement ps = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,"Trek");
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
            System.out.println("Id generado:" + id);

            Marca objMarca = MarcaDao.consultar(id:1);
            System.out.println(objMarca.toString());

            c.commit();
            ps.close();

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
        return null;
    }



    @Override
    public void actualizar(Marca objeto) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "UPDATE marcas SET nombre = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
            ps.setInt(2,(objeto.getId()));
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
            String sql= "DELETE FROM marcas WHERE id = ?";
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



    @Override
    public void insertar(Marca objeto) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "INSERT INTO marcas"
                    + "(nombre) VALUES"
                    + "(?);";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
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
}
