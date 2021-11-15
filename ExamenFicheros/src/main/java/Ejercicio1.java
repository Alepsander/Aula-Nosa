import java.io.*;
import java.util.ArrayList;

public class Ejercicio1 {

    public static void main( String[] args )
    {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();

        empleados.add(new Empleado(1, "Alejandro", "Castañeda"));
        empleados.add(new Empleado(2, "Daniel", "Ares"));
        empleados.add(new Empleado(3, "Arturo", "Pendragon"));


        EmpleadoMapping.escribirObjetos("C:\\Users\\FP\\Desktop\\Empleados.txt");

        /* for (Empleado empleado: empleados){
            System.out.println(empleado.toString());
        }*/


        EmpleadoMapping.leerEmpleados("C:\\Users\\FP\\Desktop\\Empleados.txt");
        System.out.println("Leido");
    }

}
