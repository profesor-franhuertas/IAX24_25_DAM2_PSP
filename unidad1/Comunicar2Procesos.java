/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Fran Huertas
 */

import java.io.*;
import java.util.Scanner;

public class Comunicar2Procesos {
    public static void main(String args[]) throws IOException {
           @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);
           
        String comando;
        System.out.println("Introduce el comando: ");
        comando= teclado.nextLine();
        
        Process process = new ProcessBuilder(comando).start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.println("Salida del proceso ipconfig "  + ":");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}