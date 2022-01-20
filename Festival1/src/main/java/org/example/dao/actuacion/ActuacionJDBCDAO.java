package org.example.dao.actuacion;

import org.example.connection.ConexionJDBC;
import org.example.connection.ConexionNeodatis;
import org.example.model.Actuacion;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import static org.example.connection.ConexionJDBC.obtenerConexion;

public class ActuacionJDBCDAO implements ActuacionDAO {

    private DataSource dataSource;

    @Override
    public int insertar(Actuacion objeto) {
        Connection c = null;
        ConexionJDBC conexionSQLServer = new ConexionJDBC();

        try {
            c = obtenerConexion();
            String consulta = "INSERT INTO Actuacion"
                    + "(Nombre, Descripcion, Grupo, Escenario, Inicio, Fin) VALUES"
                    + "(?,?,?,?,?,?);";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getDescripcion());
            ps.setString(3, objeto.getGrupo());
            ps.setString(4, objeto.getEscenario());
            ps.setTimestamp(5, objeto.getInicio());
            ps.setTimestamp(6, objeto.getFin());
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
        return objeto.getId();
    }

    @Override
    public void actualizar(Actuacion objeto) {
        Connection c = null;
        ConexionJDBC conexionSQLServer = new ConexionJDBC();

        try {
            c = obtenerConexion();
            String consulta = "UPDATE Actuacion SET Nombre = ?, Descripcion = ?, Grupo = ?, Escenario = ?, Inicio = ?, Fin = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getDescripcion());
            ps.setString(3, objeto.getGrupo());
            ps.setString(4, objeto.getEscenario());
            ps.setTimestamp(5, objeto.getInicio());
            ps.setTimestamp(6, objeto.getFin());

            ps.setInt(7, (objeto.getId()));
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
    public Actuacion eliminar(int id) {
        PreparedStatement sentencia = null;

        try {
            String sql = "DELETE FROM Actuacion WHERE id = ?";
            sentencia = obtenerConexion().prepareStatement(sql);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (sentencia != null) sentencia.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Actuacion consultar(int id) {

        ConexionNeodatis conexionSQLServer = new ConexionNeodatis();
        Statement sentencia = null;
        ResultSet resultado = null;
        Actuacion objeto = null;


        try {
            sentencia = obtenerConexion().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Actuacion WHERE id = ?");

            while (resultado.next()) {
                objeto = new Actuacion();
                objeto.setId(resultado.getInt("id"));
                objeto.setIdFestival(resultado.getInt("IdFestival"));
                objeto.setNombre(resultado.getString("Nombre"));
                objeto.setDescripcion(resultado.getString("Descripcion"));
                objeto.setGrupo(resultado.getString("Grupo"));
                objeto.setGrupo(resultado.getString("Escenario"));
                objeto.setInicio(resultado.getTimestamp("Inicio"));
                objeto.setFin(resultado.getTimestamp("Fin"));
                System.out.println("Nombre: " + resultado.getString("Nombre"));
                System.out.println("Descripcion: " + resultado.getString("Descripcion"));
                System.out.println("Grupo: " + resultado.getString("Grupo"));
                System.out.println("Escenario: " + resultado.getString("Escenario"));
                System.out.println("Inicio: " + resultado.getTimestamp("Inicio"));
                System.out.println("Fin: " + resultado.getTimestamp("Fin"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la consulta");
            e.printStackTrace();
        }

        return objeto;
    }

    @Override
    public List<Actuacion> listar() {
        ConexionNeodatis conexionSQLServer = new ConexionNeodatis();
        Statement sentencia = null;
        ResultSet resultado = null;

        try {
            sentencia = obtenerConexion().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Actuacion");

            while (resultado.next()) {
                Actuacion objeto = new Actuacion();
                objeto.setId(resultado.getInt("id"));
                objeto.setIdFestival(resultado.getInt("IdFestival"));
                objeto.setNombre(resultado.getString("Nombre"));
                objeto.setDescripcion(resultado.getString("Descripcion"));
                objeto.setGrupo(resultado.getString("Grupo"));
                objeto.setGrupo(resultado.getString("Escenario"));
                objeto.setInicio(resultado.getTimestamp("Inicio"));
                objeto.setFin(resultado.getTimestamp("Fin"));

                System.out.println(objeto.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}