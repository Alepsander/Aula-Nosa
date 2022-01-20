package org.example.dao.festival;

import org.example.model.Festival;

import java.util.List;

public interface FestivalDAO {

    public List<Festival> listar();

    public Festival consultar(int id);

    public int insertar(Festival objeto) throws Exception;

    public void actualizar(Festival objeto);

    public void eliminar(int id);

}
