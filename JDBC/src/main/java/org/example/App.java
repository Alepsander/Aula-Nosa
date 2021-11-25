package org.example;

import model.Marca;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.PersistenciaBBDD.obtenerConexion;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws SQLException {
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        obtenerConexion();

        //CrearTablaClientes();
        //insertarClientesSinClave();

        Marca objMarca = new Marca(10, "Trek");

        ArrayList<String> listaMarcas = new ArrayList<String>();

        listaMarcas.add("Monty");
        listaMarcas.add("Carrera");
        listaMarcas.add("Acrobatica");

        //insertarCliente(objMarca);
        //obtencionId();
        //actualizarNombreMarca(objMarca);
        //borrarMarca(objMarca);
        seleccionarRegistroUnico(objMarca);
        //seleccionarVista(objMarca);
        //insertarMarcasLotes();

        listarReposicionamiento(1,12);
    }

    public static void CrearTablaClientes() throws SQLException {
        Connection c = null;
        try {
            c = obtenerConexion();
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
            c = obtenerConexion();
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
            c = obtenerConexion();
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
        c = obtenerConexion();
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
            c = obtenerConexion();
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
            c = obtenerConexion();
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
            c = obtenerConexion();
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
            c = obtenerConexion();
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


    public static void seleccionarVista(Marca marca) {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = obtenerConexion();
            String consulta = "SELECT * FROM ventasEmpleado";
            Statement s= c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while(rs.next()){
                System.out.println("Nombre: " + rs.getString("Nombre") + " | " + "Apellidos: " + rs.getString("Apellidos") +  " | " +"Ventas: " + rs.getString("Ventas"));

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



    public static void insertarMarcasLotes(ArrayList<Marca> listaMarcas) {
        Connection c = null;
        PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

        try {
            c = obtenerConexion();

            String consulta = "INSERT listaMarcas INTO MARCAS" + "(ID, NOMBRE) VALUES" + "(?,?)";
            PreparedStatement ps = c.prepareStatement(consulta);
            obtenerConexion().prepareStatement(consulta);

            for (Marca objeto : listaMarcas) {
                ps.setString(1, String.valueOf(objeto));
                ps.addBatch();
            }

            int[] exitos = ps.executeBatch();
            obtenerConexion().commit();
            int registrosAfectados = 0;

            for (int i = 0; i < listaMarcas.size(); i++) {
                registrosAfectados = registrosAfectados + exitos[i];
            }
            /*ps.setString(1, "10");
            ps.setString(2, "Monty");
            ps.addBatch();

            ps.setString(1, "11");
            ps.setString(2, "Carrera");
            ps.addBatch();

            ps.setString(1, "12");
            ps.setString(2, "Acrobatica");
            ps.addBatch();
*/

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

        private static void actualizarLista (List<Marca> listaMarcas){

            Connection c = null;
            PersistenciaBBDD objPersistenciaBBDD = new PersistenciaBBDD();
            PreparedStatement sentencia = null;

            try {
                obtenerConexion().setAutoCommit(false);
                String sql = "UPDATE marcas SET";
                sql = sql + "nombre=?";
                sql = sql + "WHERE id = ?";
                sentencia = obtenerConexion().prepareStatement(sql);

                for (Marca marca : listaMarcas) {
                    sentencia.setString(1, marca.getNombre());
                    sentencia.setInt(2, marca.getId());
                    sentencia.addBatch();
                }

                int[] exitos = sentencia.executeBatch();
                obtenerConexion().commit();
                int registrosAfectados = 0;

                for (int i = 0; i < listaMarcas.size(); i++) {
                    registrosAfectados = registrosAfectados + exitos[i];
                }
                System.out.println("Se han actualizado" + registrosAfectados + "registros");
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

        private static void listarReposicionamiento(int secuencia, int filas){

            Connection c = null;
            PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

            Marca objeto =null;
            ResultSet resultado = null;

                try {
                    c = obtenerConexion();
                    String consulta = "SELECT TOP(?) * FROM listaClientesPorNombreOrdenado " +
                            "WHERE secuencial > ?";
                    PreparedStatement sentencia = c.prepareStatement(consulta);
                    sentencia.setInt(1, filas);
                    sentencia.setInt(2,secuencia);
                    resultado = sentencia.executeQuery();

                    while (resultado.next()){
                        String texto = resultado.getInt("secuencial") + "-"
                                +resultado.getInt("id") + "-"
                                +resultado.getString("nombre") + "-"
                                +resultado.getString("apellido") + "-"
                                +resultado.getString("email");
                        System.out.println(texto);
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


            private static void listarUltimasCompras(){
                Connection c = null;
                PersistenciaBBDD persistenciaBBDD = new PersistenciaBBDD();

                Marca objeto =null;
                ResultSet resultado = null;


                try{
                    c = obtenerConexion();
                    CallableStatement st = c.prepareCall("{call (?,?)}");

                    Date date= new Date(System.currentTimeMillis());
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    String sql = "{call ultimaVentaCliente(?)}";

                    st.setDate(1,sqlDate);

                    if (!st.execute()){
                        System.out.println("Sin resultados");
                    }else {
                        ResultSet rs = st.getResultSet();
                        while(rs.next()){
                            String texto = rs.getString("nombre") + "-"
                                    + resultado.getString("apellido") + "-"
                                    + resultado.getInt("id") + "-"
                                    + resultado.getString("ciudad") + "-"
                                    + resultado.getDate("fecha");

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











