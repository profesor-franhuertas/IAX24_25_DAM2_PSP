/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

/**
 *
 * @author Fran Huertas
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class RunProcess {
    public static void main(String[] args) throws IOException {
        if (args.length <= 0) {
            System.err.println("Se necesita un programa a ejecutar");
            System.exit(-1);
        }
//        Scanner teclado = new Scanner(System.in);
//        String comando;
//        System.out.println("Introduce comando: ");
//        comando=teclado.nextLine();        
        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            Process process = pb.start();
            int retorno = process.waitFor();
            System.out.println("La ejecución de " +
                         args + " devuelve " + retorno);
        }catch(IOException ex){
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }catch(InterruptedException ex){
            System.err.println("El proceso hijo finalizó de forma incorrecta");
            System.exit(-1);
        }
    }
}