/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

/**
 *
 * @author Fran Huertas
 */
import java.io.*;
public class Pruebas {
    public static void main(String[] args) throws IOException, InterruptedException {
            System.out.println("La memoria libre es 1:" + Runtime.getRuntime().freeMemory());
            Process ps1 = new ProcessBuilder("cmd").start();
             Process ps2 = new ProcessBuilder("cmd").start();
             BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(ps1.getOutputStream()));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(ps2.getInputStream(),"Windows-1252"));
             BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(ps2.getOutputStream()));
             BufferedReader br1 = new BufferedReader(new InputStreamReader(ps1.getInputStream(),"Windows-1252"));
             System.out.println("La memoria libre es 2:" + Runtime.getRuntime().freeMemory());
             
             //Envío el comando dir al proceso 1.
             bw1.write("type comandos.txt\n");
             bw1.close();
             ps1.waitFor(); //Espera a que finalice
             String linea;
            
             
             //Leo el resultado del proceso.
             while ((linea=br1.readLine())!=null){
                 System.out.println(linea);
                 bw2.write(linea +"\n ");
             }
             bw2.close();
             ps2.waitFor();
            while ((linea=br2.readLine())!=null)
                 System.out.println(linea);
            System.out.println("La memoria libre es 3:" + Runtime.getRuntime().freeMemory());
             
    }
}
