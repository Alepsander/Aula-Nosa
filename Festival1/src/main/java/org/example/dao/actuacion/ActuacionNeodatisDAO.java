package org.example.dao.actuacion;

import org.example.connection.ConexionNeodatis;
import org.example.model.Actuacion;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

public class ActuacionNeodatisDAO implements ActuacionDAO{
    @Override
    public int insertar(Actuacion objeto) throws Exception{
        ODB odb = ConexionNeodatis.obtenerConexion();

        IQuery query = new CriteriaQuery(Actuacion.class, Where.equal("id", objeto.getId()));
        Objects<Actuacion> objects = odb.getObjects(query);
        if(objects.size()>0) {
            throw new Exception("Id tarea duplicado");
        }
        odb.store(objeto);
        return objeto.getId();
    }


    @Override
    public void actualizar(Actuacion objeto) {
        ODB odb = ConexionNeodatis.obtenerConexion();
        IQuery query = new CriteriaQuery(Actuacion.class, Where.equal("id", objeto.getId()));
        Objects<Actuacion> objects = odb.getObjects(query);
        Actuacion objBD = null;
        if (objects.size()>0) {objBD = objects.getFirst();}

        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setGrupo(objeto.getGrupo());
        objBD.setEscenario(objeto.getEscenario());
        objBD.setInicio(objeto.getInicio());
        objBD.setFin(objeto.getFin());

        odb.store(objBD);
    }


    @Override
    public Actuacion eliminar(int id) {

        ODB odb = ConexionNeodatis.obtenerConexion();
        IQuery query = new CriteriaQuery(Actuacion.class, Where.equal("id", id));
        Objects<Actuacion> objects = odb.getObjects(query);
        Actuacion obj = null;
        if (objects.size()>0) {obj = objects.getFirst();}
        odb.delete(obj);
        return obj;
    }


    @Override
    public Actuacion consultar(int id) {
        ODB odb = ConexionNeodatis.obtenerConexion();
        IQuery query = new CriteriaQuery(Actuacion.class, Where.equal("id", id));
        Objects<Actuacion> objects = odb.getObjects(query);
        Actuacion obj = null;
        if (objects.size()>0) {obj = objects.getFirst();}

        return obj;

    }


    @Override
    public List<Actuacion> listar() {
        ODB odb = ConexionNeodatis.obtenerConexion();
        List<Actuacion> lista = new ArrayList<>();
        Objects<Actuacion> objetos=odb.getObjects(Actuacion.class);
        while (objetos.hasNext()){
            lista.add(objetos.next());
        }
        return lista;
    }
}
