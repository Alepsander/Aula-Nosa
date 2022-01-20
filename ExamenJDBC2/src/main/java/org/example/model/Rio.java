package org.example.model;

public class Rio {

    private int id;
    private String nombre;
    private int longitud;
    private int cuenca;

    public Rio() {
    }

    public Rio(int id, String nombre, int longitud, int cuenca) {
        this.id = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.cuenca = cuenca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCuenca() {
        return cuenca;
    }

    public void setCuenca(int cuenca) {
        this.cuenca = cuenca;
    }

    @Override
    public String toString() {
        return "Rio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", longitud=" + longitud +
                ", cuenca=" + cuenca +
                '}';
    }
}
