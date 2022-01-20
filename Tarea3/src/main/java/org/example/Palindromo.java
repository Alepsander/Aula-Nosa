package org.example;

import java.util.Scanner;

public class Palindromo {
    public static void palindromo() {
        Scanner entrada = new Scanner(System.in);
        int pos=0;
        StringBuffer frase, inversa;
        String s1, s2;
        System.out.println("Introduzca una frase o palabra");
        frase = new StringBuffer(entrada.nextLine());
        while (pos < frase.length())
            if (!Character.isLetter(frase.charAt(pos)))
                frase.deleteCharAt(pos);
            else
                pos++;
        inversa = new StringBuffer(frase);
        inversa.reverse();
        s1 = frase.toString();
        s2 = inversa.toString();
        if (s1.equalsIgnoreCase(s2)) //ignora si hay mayusculas o minisculas
            System.out.println("La frase introducida es un palíndromo.");
        else
            System.out.println("La frase introducida no es un palíndromo.");
    }
}
