package org.example;

import model.Marca;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws SQLException {
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        conexion.obtenerConexion();

        //CrearTablaClientes();
        //insertarClientesSinClave();

        Marca objMarca = new Marca(10, "Trek");
        //insertarCliente(objMarca);
        //obtencionId();
        //actualizarNombreMarca(objMarca);
        //borrarMarca(objMarca);
        seleccionarRegistroUnico(objMarca);
    }

    public static void CrearTablaClientes() throws SQLException {
        Connection c = null;
        try {
            c = PersistenciaBBDD.obtenerConexion();
            String consulta = "CREATE TABLE EJEMPLO"
                    + "(DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))";
            Statement s = c.createStatement();
            s.execute(consulta);
            s.close();
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la consulta");
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

    public static void insertarClientesSinClave() {
        Connection c = null;
        try {
            c = PersistenciaBBDD.obtenerConexion();
            String consulta = "INSERT INTO EJEMPLO"
                    + "(DNI, APELLIDOS,CP) VALUES"
                    + "('78978978A', 'NADAL', '15009'),"
                    + "('12345678F', 'DJOKOVIC', '15008'),"
                    + "('55544587J', 'FEDERER', '15007'),"
                    + "('88965475K', 'MURRAY', '15006')";

            Statement s = c.createStatement();
            s.executeUpdate(consulta);
            s.close();

        } catch (SQLException e) {
            System.out.println("Error en la ejecucion de la consulta");
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

    public static void insertarCliente(Marca marca) {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = PersistenciaBBDD.obtenerConexion();
            String consulta = "INSERT INTO marcas"
                    + "(nombre) VALUES"
                    + "(?);";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, marca.getNombre());
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


    public static void obtencionId(){
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

       try{
        c = PersistenciaBBDD.obtenerConexion();
        String consulta = "INSERT INTO MARCAS" + "(NOMBRE) VALUES " + "(?)";
        PreparedStatement ps = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,"Trek");
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
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



    public static void actualizarNombreMarca(Marca marca) {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = PersistenciaBBDD.obtenerConexion();
            String consulta = "UPDATE marcas SET nombre = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, marca.getNombre());
            ps.setInt(2,(marca.getId()));
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


    public static void borrarMarca(Marca marca) {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = PersistenciaBBDD.obtenerConexion();
            String consulta = "DELETE FROM marcas WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setString(1, marca.getNombre());
            ps.setInt(1,(marca.getId()));
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

    public static void seleccionarRegistrosLista(Marca marca) {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = PersistenciaBBDD.obtenerConexion();
            String consulta = "SELECT NOMBRE FROM MARCAS";
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



    public static void seleccionarRegistroUnico(Marca marca) {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = PersistenciaBBDD.obtenerConexion();
            String consulta = "SELECT NOMBRE FROM MARCAS WHERE ID = 1";
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

    public static void insertarClientesLotes() {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = PersistenciaBBDD.obtenerConexion();

            String consulta = "INSERT INTO CLIENTES" + "(DNI, APELLIDOS, CP) VALUES" + "(?,?,?)";
            PreparedStatement ps = c.prepareStatement(consulta);

            ps.setString(1, "22222222F");
            ps.setString(2, "Medvédev");
            ps.setString(3, "21001");
            ps.addBatch();

            ps.setString(1, "33333333F");
            ps.setString(2, "Tsitsipas");
            ps.setString(3, "21002");
            ps.addBatch();

            ps.setString(1, "44444444F");
            ps.setString(2, "Anisimova");
            ps.setString(3, "21003");
            ps.addBatch();

            ps.executeBatch();
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
}
