package org.example.dao.festival;

import org.example.connection.ConexionMongoDB;
import org.example.connection.ConexionORM;
import org.example.model.Festival;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FestivalORMDAO implements FestivalDAO{

    @Override
    public List<Festival> listar(){
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        List<Festival> lista = conexion.createQuery("from Festival", Festival.class).getResultList();
        tx.commit();
        return lista;
    }

    @Override
    public Festival consultar(int id){
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival obj = conexion.get(Festival.class, id);
        tx.commit();
        return obj;
    }

    @Override
    public void actualizar(Festival objeto){
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival objBD =conexion.load(Festival.class, objeto.getId());
        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setInicio(objeto.getInicio());
        objBD.setFin(objeto.getFin());
        objBD.setAforo(objeto.getAforo());
        objBD.setPrecio(objeto.getPrecio());
        objBD.setVentas(objeto.getVentas());
    }


    @Override
    public int insertar(Festival objeto){
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        conexion.save(objeto);
        tx.commit();

        return objeto.getId();
    }

    @Override
    public void eliminar(int id){
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival obj = conexion.load(Festival.class, id);
        conexion.delete(obj);
        tx.commit();

    }

}
