package org.example.festival;

import com.mongodb.client.MongoDatabase;
import org.example.connection.ConexionMongoDB;
import org.example.connection.ConexionNeodatis;
import org.example.dao.festival.FestivalDAO;
import org.example.dao.festival.FestivalMongoDBDAO;
import org.example.model.Festival;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.awt.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class FestivalMongoDBTest {

    FestivalDAO daoFestival = new FestivalMongoDBDAO();

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
            }
        }


            @Test
            public void t02Consultar(){
                Festival objeto = daoFestival.consultar(idInsertado);
                assertEquals("Rua Nova 23", objeto.getDescripcion());
            }



            @Test
            public void t03Listar(){
                List<Festival>lista = daoFestival.listar();
                assertTrue(lista.size()>0);
            }


            @Test
            public void t04ActualizarDescripcion(){
                Festival objeto= daoFestival.consultar(idInsertado);
                objeto.setDescripcion("Cambio descripcion");
                daoFestival.actualizar(objeto);

                Festival objetoActualizado = daoFestival.consultar(idInsertado);
                assertEquals("Cambio descripcion", objetoActualizado.getDescripcion());
          }


            @Test
            public void t05Eliminar(){
                daoFestival.eliminar(idInsertado);
                Festival objeto = daoFestival.consultar(idInsertado);
                assertNull(objeto);
            }

            @Test
            public void t99CerrarConexion(){
                ConexionMongoDB.cerrarConexion();
                assertTrue(true);
            }
}
