package org.example.dao.actuacion;

import org.example.connection.ConexionORM;
import org.example.model.Actuacion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActuacionORMDAO implements ActuacionDAO{
    @Override
    public int insertar(Actuacion objeto) throws Exception {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        conexion.save(objeto);
        tx.commit();

        return objeto.getId();
    }

    @Override
    public void actualizar(Actuacion objeto) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion objBD = conexion.load(Actuacion.class, objeto.getId());
        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setInicio(objeto.getInicio());
        objBD.setFin(objeto.getFin());
        objBD.setEscenario(objeto.getEscenario());
        objBD.setGrupo(objeto.getGrupo());
        conexion.update(objBD);
        tx.commit();
    }

    @Override
    public Actuacion eliminar(int id) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion obj = conexion.load(Actuacion.class, id);
        conexion.delete(obj);
        tx.commit();
        return null;
    }

    @Override
    public Actuacion consultar(int id) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion obj =conexion.get(Actuacion.class,id);
        tx.commit();
        return obj;
    }

    @Override
    public List<Actuacion> listar() {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        List<Actuacion> lista = conexion.createQuery("from Actuacion", Actuacion.class).getResultList();
        tx.commit();
        return lista;

    }
}
