package org.example.festival;

import org.example.connection.ConexionNeodatis;
import org.example.dao.actuacion.ActuacionDAO;
import org.example.dao.actuacion.ActuacionNeodatisDAO;
import org.example.dao.festival.FestivalDAO;
import org.example.dao.festival.FestivalNeodatisDAO;
import org.example.model.Festival;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FestivalNeodatisTest {

    FestivalDAO festivalDAO = new FestivalNeodatisDAO();
    ActuacionDAO actuacionDAO = new ActuacionNeodatisDAO();


    private static int idInsertado;

    @Test
    public void testInsertar() {

        try {
            String fecha = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fecha);
            Timestamp fecInsertarInicio = new Timestamp(parsedDate.getTime());

            String fecha2 = "10/03/2022 11:00";
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate2 = dateFormat2.parse(fecha2);
            Timestamp fecInsertarFinal = new Timestamp(parsedDate2.getTime());

            FestivalDAO dao = new FestivalNeodatisDAO();
            Festival objeto = new Festival();
            objeto.setId(1);
            objeto.setNombre("Ensayo");
            objeto.setDescripcion("Ensayo grupal");
            objeto.setAforo(800);
            objeto.setVentas(750);
            objeto.setPrecio(35);
            objeto.setInicio(fecInsertarInicio);
            objeto.setFin(fecInsertarFinal);
            idInsertado = dao.insertar(objeto);
            assertTrue(idInsertado > 0);


            assertTrue(true);
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void t02Consultar() {
        Festival objeto = festivalDAO.consultar(idInsertado);
        assertEquals("Resurrection", objeto.getNombre());
        System.out.println("Done");
    }


    @Test
    public void t03ActualizarDescripcion(){

        Festival objeto = festivalDAO.consultar(idInsertado);
        objeto.setDescripcion("Cambio descripcion");
        festivalDAO.actualizar(objeto);

        Festival objetoActualizado = festivalDAO.consultar(idInsertado);
        assertEquals("Cambio descripcion",
                objetoActualizado.getDescripcion());
    }

    @Test
    public void t04Eliminar(){

        festivalDAO.eliminar(idInsertado);
        Festival objeto = festivalDAO.consultar(idInsertado);
        assertNull(objeto);
    }

    @Test
    public void t05Listar(){

        List<Festival> lista = festivalDAO.listar();
        assertTrue(lista.size()>0);
    }

    @Test
    public void t99CerrarConexion(){
        ConexionNeodatis.cerrarConexion();
        assertTrue(true);
    }
}
