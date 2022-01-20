package org.example.actuacion;

import org.example.connection.ConexionNeodatis;
import org.example.dao.actuacion.ActuacionDAO;
import org.example.dao.actuacion.ActuacionJDBCDAO;
import org.example.dao.actuacion.ActuacionNeodatisDAO;
import org.example.dao.festival.FestivalDAO;
import org.example.dao.festival.FestivalNeodatisDAO;
import org.example.model.Actuacion;
import org.example.model.Festival;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ActuacionNeodatisTest {

    //FestivalDAO festivalDAO = new FestivalNeodatisDAO();
    ActuacionDAO actuacionDAO = new ActuacionNeodatisDAO();


    private static int idInsertado;

    @Test
    public void testInsertar()
    {

        try{
            String fecha = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fecha);
            Timestamp fecInsertarInicio = new Timestamp(parsedDate.getTime());

            String fecha2 = "10/03/2022 11:00";
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate2 = dateFormat2.parse(fecha2);
            Timestamp fecInsertarFinal= new Timestamp(parsedDate2.getTime());

            ActuacionDAO dao = new ActuacionJDBCDAO();
            Actuacion objeto = new Actuacion();
            objeto.setId(1);
            objeto.setIdFestival(1);
            objeto.setNombre("Ensayo");
            objeto.setDescripcion("Ensayo grupal");
            objeto.setGrupo("Sum 41");
            objeto.setEscenario("Escenario 1");
            objeto.setInicio(fecInsertarInicio);
            objeto.setFin(fecInsertarFinal);
            idInsertado = dao.insertar(objeto);
            assertTrue(idInsertado>0);


            assertTrue( true );
            System.out.println("Done");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void t02Consultar() {
        ActuacionJDBCDAO actuacionJDBCDAO = new ActuacionJDBCDAO();

        Actuacion objeto = actuacionJDBCDAO.consultar(1);
        assertEquals("Ensayo", objeto.getNombre());
        System.out.println("Done");
    }

    @Test
    public void t03ActualizarDescripcion(){

        ActuacionNeodatisDAO actuacionNeodatisDAO = new ActuacionNeodatisDAO();
        Actuacion objeto = actuacionNeodatisDAO.consultar(1);
        objeto.setDescripcion("Cambio descripcion");
        actuacionNeodatisDAO.actualizar(objeto);

        Actuacion objetoActualizado = actuacionNeodatisDAO.consultar(1);
        assertEquals("Cambio descripcion",
                objetoActualizado.getDescripcion());
    }

    @Test
    public void t04Eliminar(){
        ActuacionJDBCDAO actuacionJDBCDAO = new ActuacionJDBCDAO();

        Actuacion objeto = actuacionJDBCDAO.eliminar(1);
        assertNull(objeto);

    }

    @Test
    public void t05Listar(){

        ActuacionNeodatisDAO actuacionNeodatisDAO = new ActuacionNeodatisDAO();
        List<Actuacion> lista = actuacionNeodatisDAO.listar();
        assertTrue(lista.size()>0);
    }


}
