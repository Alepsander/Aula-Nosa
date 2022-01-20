package org.example.dao;

import org.example.model.Rio;
import org.example.connection.ConexionSQLServer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.connection.ConexionSQLServer.obtenerConexion;

public class RioDAOSQLServer implements RioDAO {

    @Override
    public void insertar(Rio objeto) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "INSERT INTO Rio"
                    + "(Nombre, Longitud, Cuenca) VALUES"
                    + "(?,?,?);";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, objeto.getLongitud());
            ps.setInt(3, objeto.getCuenca());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Rio objeto) {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "UPDATE Rio SET nombre = ?, longitud = ?, cuenca = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, (objeto.getLongitud()));
            ps.setInt(3, (objeto.getCuenca()));
            ps.setInt(4, (objeto.getId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        PreparedStatement sentencia = null;

        try {
            String sql = "DELETE FROM Rio WHERE id = ?";
            sentencia = obtenerConexion().prepareStatement(sql);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Override
    public Rio consultar(int id) {
        Rio objeto = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            String sql = "SELECT * FROM Rio WHERE ID = ?";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                objeto = new Rio();
                objeto.setId(resultado.getInt("Id"));
                objeto.setNombre(resultado.getString("Nombre"));
                System.out.println("Nombre: " + resultado.getString("Nombre"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return objeto;
    }


    public List<Rio> listarVista() {
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();
            String consulta = "SELECT * FROM vtRiosLargos";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("Nombre") + " | " + "Longitud: " + rs.getInt("Longitud"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Rio> listarSP(){
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        Rio objeto =null;

        try{
            c = obtenerConexion();
            String sql = "{call spRiosCuencaMayorA (?)}";

            CallableStatement st = c.prepareCall(sql);

            st.setString(1, "1");
            if (!st.execute()){

            }else {
                ResultSet rs = st.getResultSet();
                while(rs.next()){
                    String texto = rs.getString("Nombre") + "-"
                            + rs.getInt("Cuenca");
                    System.out.println(texto);
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void insertarRiosLotes(ArrayList<Rio> listaRios){
        Connection c = null;
        ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

        try {
            c = obtenerConexion();

            String consulta = "INSERT INTO Rio" + "(Nombre, Longitud, Cuenca) VALUES" + "(?,?,?)";
            PreparedStatement ps = c.prepareStatement(consulta);
            obtenerConexion().prepareStatement(consulta);

            for (Rio objeto : listaRios) {
                ps.setString(1, objeto.getNombre());
                ps.setInt(2, objeto.getLongitud());
                ps.setInt(3, objeto.getCuenca());
                ps.addBatch();
            }

            int[] exitos = ps.executeBatch();
            obtenerConexion().commit();
            int registrosAfectados = 0;

            for (int i = 0; i < listaRios.size(); i++) {
                registrosAfectados = registrosAfectados + exitos[i];
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
            }
        }
    }
}