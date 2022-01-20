package org.example.actuacion;

import com.mongodb.client.MongoDatabase;
import org.example.connection.ConexionMongoDB;
import org.example.dao.actuacion.ActuacionDAO;
import org.example.dao.actuacion.ActuacionMongoDBDAO;
import org.example.dao.festival.FestivalDAO;
import org.example.dao.festival.FestivalMongoDBDAO;
import org.example.model.Actuacion;
import org.example.model.Festival;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActuacionMongoDBTest {

    ActuacionDAO daoActuacion = new ActuacionMongoDBDAO();

    private static int idInsertado;
    @Test
    public void t00ProbarConexion(){
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
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

            Actuacion objeto = new Actuacion();
            objeto.setId(2);
            objeto.setIdFestival(2);
            objeto.setNombre("Obra Ferrol");
            objeto.setDescripcion("Rua Nova 23");
            objeto.setInicio(fecInsertar);
            objeto.setFin(fecFinal);
            objeto.setEscenario("Escenario 1");
            objeto.setGrupo("Sum 41");
            idInsertado = daoActuacion.insertar(objeto);
            assertTrue(idInsertado>0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void t02Consultar(){
        Actuacion objeto = daoActuacion.consultar(idInsertado);
        assertEquals("Rua Nova 23", objeto.getDescripcion());
    }



    @Test
    public void t03Listar(){
        List<Actuacion> lista = daoActuacion.listar();
        assertTrue(lista.size()>0);
    }


    @Test
    public void t04ActualizarDescripcion(){
        Actuacion objeto= daoActuacion.consultar(idInsertado);
        objeto.setDescripcion("Cambio descripcion");
        daoActuacion.actualizar(objeto);

        Actuacion objetoActualizado = daoActuacion.consultar(idInsertado);
        assertEquals("Cambio descripcion", objetoActualizado.getDescripcion());
    }


    @Test
    public void t05Eliminar(){
        daoActuacion.eliminar(idInsertado);
        Actuacion objeto = daoActuacion.consultar(idInsertado);
        assertNull(objeto);
    }

    @Test
    public void t99CerrarConexion(){
        ConexionMongoDB.cerrarConexion();
        assertTrue(true);
    }
}

