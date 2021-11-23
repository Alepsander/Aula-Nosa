package org.example;

import org.example.connection.ConexionSQLServer;
import org.example.dao.HeroeDAO;
import org.example.dao.HeroeDAOSQLServer;
import org.example.model.Heroe;

import java.sql.*;

import static org.example.connection.ConexionSQLServer.obtenerConexion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int main(String[] args ) throws SQLException {

        HeroeDAOSQLServer heroeDaoSQLServer = new HeroeDAOSQLServer();

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

        public Heroe consultar(int id = 0) {
            Connection c = null;
            ConexionSQLServer conexionSQLServer = new ConexionSQLServer();

            try{
                c = obtenerConexion();
                String consulta = "INSERT INTO Heroes" + "(Nombre, Clase, Raza) VALUES " + "(?,?,?)";
                PreparedStatement ps = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,"Nidhogg");
                ps.setString(2, "Caballero");
                ps.setString(3, "8");
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                rs.getInt(1);
                System.out.println("Id generado:" + id);

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
        }

        return 0;
    }
}
