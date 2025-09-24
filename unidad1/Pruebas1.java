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
public class Pruebas1 {
    public static void main(String[] args) throws IOException, InterruptedException {
            System.out.println("La memoria libre es 1:" + Runtime.getRuntime().freeMemory());
            Process ps1 = new ProcessBuilder("cmd").start();
             Process ps2 = new ProcessBuilder("cmd").start();
             PrintWriter bw1 = new PrintWriter(new OutputStreamWriter(ps1.getOutputStream()),true);
             BufferedReader br2 = new BufferedReader(new InputStreamReader(ps2.getInputStream(),"Windows-1252"));
             PrintWriter bw2 = new PrintWriter(new OutputStreamWriter(ps2.getOutputStream()),true);
             BufferedReader br1 = new BufferedReader(new InputStreamReader(ps1.getInputStream(),"Windows-1252"));
             System.out.println("La memoria libre es 2:" + Runtime.getRuntime().freeMemory());
             bw1.print("dir\n");
            // ps1.waitFor();
             bw1.close();
             String linea;
             
             while (br1.ready()){
                 System.out.println((char)br1.read());
                 //bw2.print(linea);
             }
            
        //     ps2.waitFor();
            while ((linea=br2.readLine())!=null)
                 System.out.println(linea);
            System.out.println("La memoria libre es 3:" + Runtime.getRuntime().freeMemory());
             
    }
}
