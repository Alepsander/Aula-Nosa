package org.example.dao.actuacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.connection.ConexionMongoDB;
import org.example.model.Actuacion;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ActuacionMongoDBDAO implements ActuacionDAO {

    private static final String COLECCION = "actuaciones";

    private Document actuacionADoc(Actuacion objActuacion){
        Document objDoc = null;

        if (objActuacion != null){
            objDoc = new Document();
            objDoc.put("id", objActuacion.getId());
            objDoc.put("idFestival", objActuacion.getIdFestival());
            objDoc.put("nombre", objActuacion.getNombre());
            objDoc.put("descripcion", objActuacion.getDescripcion());
            objDoc.put("inicio", objActuacion.getInicio());
            objDoc.put("fin", objActuacion.getFin());
            objDoc.put("grupo", objActuacion.getGrupo());
            objDoc.put("escenario", objActuacion.getEscenario());

        }

        return objDoc;
    }

    private Actuacion docAActuacion(Document objDoc){
        Actuacion objActuacion = null;

        if(objDoc!=null){
            objActuacion = new Actuacion();
            if (objDoc.getInteger("id") != null){
                objActuacion.setId(objDoc.getInteger("id"));
            }
            objActuacion.setIdFestival(objDoc.getInteger("idFestival"));
            objActuacion.setNombre(objDoc.getString("nombre"));
            objActuacion.setDescripcion(objDoc.getString("descripcion"));
            objActuacion.setGrupo(objDoc.getString("grupo"));
            objActuacion.setEscenario(objDoc.getString("escenario"));
        }
        return objActuacion;
    }


    @Override
    public List<Actuacion> listar() {
        List<Actuacion> resultado = new ArrayList<>();
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        List<Document> consulta = colMongo.find().into(new ArrayList<Document>());
        Actuacion actuacion = new Actuacion();
        for (int i = 0; i < consulta.size(); i++){
            actuacion = docAActuacion(consulta.get(i));
            resultado.add(actuacion);
        }

        return resultado;
    }

    @Override
    public Actuacion consultar(int id) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = colMongo.find(eq("id",id)).first();
        return docAActuacion(documento);
    }


    @Override
    public int insertar(Actuacion objeto) throws Exception {
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = actuacionADoc(objeto);
        try{
            colMongo.insertOne(documento);
            return objeto.getId();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void actualizar(Actuacion objeto) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = actuacionADoc(objeto);

        try{
            colMongo.replaceOne(Filters.eq("id", objeto.getId()), documento);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Actuacion eliminar(int id) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        try{
            colMongo.deleteOne(Filters.eq("id", id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

