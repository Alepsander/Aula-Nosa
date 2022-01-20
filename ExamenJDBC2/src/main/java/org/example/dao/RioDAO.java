package org.example.dao;

import org.example.model.Rio;

import java.util.List;

public interface RioDAO {


    public void insertar(Rio objeto);

    public void actualizar(Rio objeto);

    public void eliminar(int id);

    public Rio consultar(int id);

    public List<Rio> listarVista();

}
