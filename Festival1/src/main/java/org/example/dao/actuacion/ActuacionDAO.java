package org.example.dao.actuacion;

import org.example.model.Actuacion;

import java.util.List;

public interface ActuacionDAO {

    public int insertar(Actuacion objeto) throws Exception;

    public void actualizar(Actuacion objeto);

    public Actuacion eliminar(int id);

    public Actuacion consultar(int id);

    public List<Actuacion> listar();
}

