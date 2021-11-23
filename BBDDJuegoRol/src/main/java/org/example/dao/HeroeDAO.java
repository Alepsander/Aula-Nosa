package org.example.dao;

import org.example.model.Heroe;

public interface HeroeDAO {
    public void insertar(Heroe objeto);

    public void actualizar(Heroe objeto);

    public void eliminar(int id);
/*
    public Heroe consultar(int id);

    public List<Heroe> listar();

*/
}
