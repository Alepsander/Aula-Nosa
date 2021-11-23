package org.example;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class BAT {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD");

        File fBat = new File("fichero.bat");
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");

        pb.redirectInput();
        pb.redirectOutput();
        pb.redirectError();
    }
}