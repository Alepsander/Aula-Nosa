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
    }

    private static void ejercicio1(){

        int num1=10;
        int num2=5;

        System.out.println("La suma de los dos numeros es " + (num1 + num2));
        System.out.println("La resta de los dos numeros es " + (num1 - num2));
        System.out.println("El multiplo de los dos numeros es " + (num1 * num2));
        System.out.println("La division de los dos numeros es " + (num1 / num2));
        System.out.println("El resto de la division de los dos numeros es " + (num1 % num2));

    }

    private static void ejercicio2(){

        int num;

        for (num=1; num<=100; num++){

            System.out.print(num+",");
        }
    }

    private static void ejercicio3(){

            Calendar cal= Calendar.getInstance();

            int diaSemana =cal.get(Calendar.DAY_OF_WEEK);

            switch(diaSemana){
                case 1: System.out.println("Hoy es domingo");
                case 2: System.out.println("Hoy es lunes");
                case 3: System.out.println("Hoy es martes");
                case 4: System.out.println("Hoy es miercoles");
                case 5: System.out.println("Hoy es jueves");
                case 6: System.out.println("Hoy es viernes");
                case 7: System.out.println("Hoy es sabado");

            }
    }

    private static void ejercicio4(){

       ArrayList<String> listaA = new ArrayList<String>();
       ArrayList<String> listaB = new ArrayList<String>();

        listaA.add("blanco");
        listaA.add("verde");
        listaA.add("amarillo");

        listaB.add("morado");
        listaB.add("verde");
        listaB.add("amarillo");


        for (String element : listaB) {
            if (!listaA.contains(element)) {
                System.out.println(element + "no existe en lista A");
            }
        }

        for (String element : listaA){
            if (!listaB.contains(element)) {
                System.out.println(element + "no existe en lista B");
            }
        }
    }



}

