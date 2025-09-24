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
import java.util.Scanner;

public class RuntimeProcess {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String comando;
        System.out.println("Introduce comando: ");
        comando=teclado.nextLine();
//        if (args.length <= 0) {
//            System.err.println("Se necesita un programa a ejecutar");
//            System.exit(-1);
//        }
        Runtime runtime = Runtime.getRuntime();
        try {
            System.out.println("Creando un proceso");
            Process process = runtime.exec(comando);
            System.out.println("Desea eliminar el proceso(si/no):");
            if( teclado.nextLine().equals("si")){
                System.out.println("Destruyendo el proceso");
                process.destroy();
            }
        }catch(IOException ex){
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}