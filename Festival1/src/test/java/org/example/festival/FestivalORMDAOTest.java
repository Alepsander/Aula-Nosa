package org.example.festival;


import org.example.connection.ConexionORM;
import org.example.dao.festival.FestivalDAO;
import org.example.dao.festival.FestivalORMDAO;
import org.example.model.Festival;
import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FestivalORMDAOTest {

    FestivalDAO daoFestival = new FestivalORMDAO();

    private static int idInsertado;

    @Test
    public void t00ProbarConexion(){
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        assertNotNull(conexion);
    }


    @Test
    public void t01Insertar(){
        try{
            String fecha = "10/03/2022 10:00";
            SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fecha);
            Timestamp fecInsertar = new Timestamp(parsedDate.getTime());
            Timestamp fecFinal = new Timestamp(parsedDate.getTime());

            Festival objeto = new Festival();
            objeto.setId(2);
            objeto.setNombre("Obra Ferrol");
            objeto.setDescripcion("Rua Nova 23");
            objeto.setInicio(fecInsertar);
            objeto.setFin(fecFinal);
            objeto.setAforo(500);
            objeto.setVentas(480);
            objeto.setPrecio(15);
            idInsertado = daoFestival.insertar(objeto);
            assertTrue(idInsertado>0);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void t02Consultar() {
        try {
            Festival objeto = daoFestival.consultar(idInsertado);
            assertEquals("Rua Nova 23", objeto.getDescripcion());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }


    @Test
    public void t03Listar() {
        try {
            List<Festival> lista = daoFestival.listar();
            assertTrue(lista.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void t04ActualizarDescripcion() {
        try {
            Festival objeto = daoFestival.consultar(idInsertado);
            objeto.setDescripcion("Cambio descripcion");
            daoFestival.actualizar(objeto);

            Festival objetoActualizado = daoFestival.consultar(idInsertado);
            assertEquals("Cambio descripcion", objetoActualizado.getDescripcion());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void t05Eliminar() {
        try {
            daoFestival.eliminar(idInsertado);
            Festival objeto = daoFestival.consultar(idInsertado);
            assertNull(objeto);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
