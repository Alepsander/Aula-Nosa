package org.example.dao;

import org.example.connection.ConexionSQLServer;
import org.example.model.Heroe;

import java.sql.*;
import java.util.ArrayList;

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


    public static void Consultar(Heroe heroe) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "SELECT NOMBRE FROM HEROES WHERE ID = 1";
            Statement s= c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while(rs.next()){
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
    }

    public static void Listar(){
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();
        Statement sentencia = null;
        ResultSet resultado = null;

        try{
            sentencia = obtenerConexion().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Heroes");

            while(resultado.next()){
                Heroe objeto = new Heroe();
                objeto.setId(resultado.getInt("Id"));
                objeto.setNombre(resultado.getString("Nombre"));
                objeto.setClase(resultado.getString("Clase"));
                objeto.setRaza(String.valueOf((resultado.getInt("Raza"))));
                System.out.println(objeto.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void VistaHeroesOrdenAlfabetico() {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "SELECT * FROM listaHeroesPorNombre";
            Statement s= c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while(rs.next()){
                System.out.println("Nombre: " + rs.getString("Nombre") + " | " + "Clase: " + rs.getString("Clase"));

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
    }


    public static void insertarHeroesLotes(ArrayList<Heroe> listaHeroes) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();

            String consulta = "INSERT  INTO Heroes" + "(NOMBRE, CLASE, RAZA) VALUES" + "(?,?,?)";
            PreparedStatement ps = c.prepareStatement(consulta);
            obtenerConexion().prepareStatement(consulta);

            for (Heroe objeto : listaHeroes) {
                ps.setString(1, objeto.getNombre());
                ps.setString(2, objeto.getClase());
                ps.setString(3, objeto.getRaza());
                ps.addBatch();
            }

            int[] exitos = ps.executeBatch();
            obtenerConexion().commit();
            int registrosAfectados = 0;

            for (int i = 0; i < listaHeroes.size(); i++) {
                registrosAfectados = registrosAfectados + exitos[i];
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
    }

    public static void listarHeroesPorRazas(){
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        Heroe objeto =null;

        try{
            c = obtenerConexion();
            String sql = "{call heroesPorRaza(?)}";

            CallableStatement st = c.prepareCall(sql);

            st.setString(1, "1");
            if (!st.execute()){
                System.out.println("Sin resultados");
            }else {
                ResultSet rs = st.getResultSet();
                while(rs.next()){
                    String texto = rs.getString("Nombre") + "-"
                            + rs.getString("Raza");
                    System.out.println(texto);
                }
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
    }
    }
