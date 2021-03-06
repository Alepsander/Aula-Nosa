package org.example.dao.festival;

import org.example.connection.ConexionNeodatis;
import org.example.model.Festival;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

public class FestivalNeodatisDAO implements FestivalDAO{

    @Override
    public List<Festival> listar() {
        ODB odb = ConexionNeodatis.obtenerConexion();

        List<Festival> lista = new ArrayList<>();
        Objects<Festival> objetos=odb.getObjects(Festival.class);
        while (objetos.hasNext()){
            lista.add(objetos.next());
        }
        return lista;
    }

    @Override
    public Festival consultar(int id) {
        ODB odb = ConexionNeodatis.obtenerConexion();

        IQuery query = new CriteriaQuery(Festival.class, Where.equal("Id", id));
        Objects<Festival> objects = odb.getObjects(query);
        Festival obj = null;
        if (objects.size()>0) {obj = objects.getFirst();}

        return obj;

    }

    @Override
    public int insertar(Festival objeto) throws Exception{
        ODB odb = ConexionNeodatis.obtenerConexion();

        IQuery query = new CriteriaQuery(Festival.class, Where.equal("id", objeto.getId()));
        Objects<Festival> objects = odb.getObjects(query);
        if(objects.size()>0) {
            throw new Exception("Id tarea duplicado");
        }
        odb.store(objeto);
        return objeto.getId();

    }

    @Override
    public void actualizar(Festival objeto) {
        ODB odb = ConexionNeodatis.obtenerConexion();
        IQuery query = new CriteriaQuery(Festival.class, Where.equal("Id", objeto.getId()));
        Objects<Festival> objects = odb.getObjects(query);
        Festival objBD = null;
        if (objects.size()>0) {objBD = objects.getFirst();}

        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setAforo(objeto.getAforo());
        objBD.setPrecio(objeto.getPrecio());
        objBD.setVentas(objeto.getVentas());
        objBD.setInicio(objeto.getInicio());
        objBD.setFin(objeto.getFin());

        odb.store(objBD);

    }

    @Override
    public void eliminar(int id) {

        ODB odb = ConexionNeodatis.obtenerConexion();
        IQuery query = new CriteriaQuery(Festival.class, Where.equal("Id", id));
        Objects<Festival> objects = odb.getObjects(query);
        Festival obj = null;
        if (objects.size()>0) {obj = objects.getFirst();}
        odb.delete(obj);
    }
}
