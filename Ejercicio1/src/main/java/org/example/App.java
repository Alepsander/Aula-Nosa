package org.example;

import com.sun.beans.decoder.StringElementHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ejercicio1();

        ejercicio2();

        ejercicio3();

        ejercicio4();

        ejercicio5();

        ejercicio6();
    }

    //Declarar dos variables numericas con valores 10 y 5 y mostrar por consola la suma, resta, multiplicacion, division y módulo(resto de la division)
    private static void ejercicio1(){

        int num1=10;
        int num2=5;

        System.out.println("La suma de los dos numeros es " + (num1 + num2));
        System.out.println("La resta de los dos numeros es " + (num1 - num2));
        System.out.println("El multiplo de los dos numeros es " + (num1 * num2));
        System.out.println("La division de los dos numeros es " + (num1 / num2));
        System.out.println("El resto de la division de los dos numeros es " + (num1 % num2));

    }


    //Mostrar los numeros del 1 al 100 (ambos incluidos) separados por comas
    private static void ejercicio2(){

        int num;

        for (num=1; num<=100; num++){

            System.out.print(num+",");
        }
    }



    //Mostrar el dia actual en texto(lunes,martes...) Usar calendar y switch.
    private static void ejercicio3(){

            Calendar cal= Calendar.getInstance();

            int diaSemana =cal.get(Calendar.DAY_OF_WEEK);

            switch(diaSemana){
                case 1: System.out.println("Hoy es domingo"); break;
                case 2: System.out.println("Hoy es lunes"); break;
                case 3: System.out.println("Hoy es martes");break;
                case 4: System.out.println("Hoy es miercoles");break;
                case 5: System.out.println("Hoy es jueves");break;
                case 6: System.out.println("Hoy es viernes");break;
                case 7: System.out.println("Hoy es sabado");break;
                default: System.out.println("ERROR");break;

            }
    }



    //Crear dos ArrayList<String> e imprimir los valores que existan en una de ellas y no en la otra
    private static void ejercicio4(){

       ArrayList<String> listaA = new ArrayList<String>();
       ArrayList<String> listaB = new ArrayList<String>();

        listaA.add("Blanco");
        listaA.add("Verde");
        listaA.add("Amarillo");

        listaB.add("Morado");
        listaB.add("Verde");
        listaB.add("Amarillo");


        for (String element : listaB) {
            if (!listaA.contains(element)) {
                System.out.println(element + " no existe en lista A");
            }
        }

        for (String element : listaA){
            if (!listaB.contains(element)) {
                System.out.println(element + " no existe en lista B");
            }
        }
    }


    //Crear una clase vehiculo con un atributo "velocidad" y heredarla para la clase "coche" con atributo numeroRuedas. Instanciar un coche con velocidad 40 y 4 ruedas
    private static void ejercicio5(){

    Coche objetoCoche = new Coche( 40,  4);

    System.out.println("Mi coche va a " + objetoCoche.getVelocidad()
                        + " km/h y tiene " + objetoCoche.getNumeroRuedas() + "ruedas");

    }


    //Crear una interface "volador" con metodo "volar", implementarla en una clase "gaviota" donde el metodo volar imprima en consola "vuelo y tengo pico". Instanciar la interface a partir de gaviota y llamar a volar.

    private static void ejercicio6(){
        Volador objetoVolador = new Gaviota();
        objetoVolador.volar();
    }

}

