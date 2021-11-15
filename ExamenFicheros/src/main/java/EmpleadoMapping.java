import java.io.*;
import java.util.ArrayList;

public class EmpleadoMapping {

    public static ArrayList<Empleado> leerEmpleados(String ruta) {

        ArrayList<Empleado> empleados = new ArrayList<>();

        File fic = new File("C:\\Users\\FP\\Desktop\\Empleados.txt");
        FileInputStream ficStream = null;
        ObjectInputStream ficObj = null;

        try {

            ficStream = new FileInputStream("C:\\Users\\FP\\Desktop\\Empleados.txt");
            ficObj = new ObjectInputStream(ficStream);

            Empleado obj = (Empleado) ficObj.readObject();

            System.out.println(obj.getCodigo() + obj.getNombre()+ obj.getApellidos());

            //TODO Solucionar el problema de la excepcion para lograr leer el fichero correctamente

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public static boolean escribirObjetos(String ruta){

        ArrayList<Empleado> empleados = new ArrayList<>();

        File fic = new File(ruta);
        FileOutputStream ficStream = null;
        ObjectOutputStream ficObj = null;

        try{
            ficStream = new FileOutputStream(fic);
            ficObj = new ObjectOutputStream(ficStream);

            for (Empleado empleado: empleados){
                ficObj.writeObject(empleado);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
