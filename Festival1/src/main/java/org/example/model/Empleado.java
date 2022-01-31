package org.example.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Empleado")
public class Empleado {

    private int id;
    private String nombre;
    private Set<Actuacion> actuaciones;

    public Empleado(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name ="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Actuacion> getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(Set<Actuacion> actuaciones) {
        this.actuaciones = actuaciones;
    }
}
