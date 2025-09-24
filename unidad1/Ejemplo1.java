

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import java.util.Scanner;
 
 /**
  *
  * @author fran
  */
 public class Ejemplo1 {
     public static void main(String[] args) {
         Runtime r = Runtime.getRuntime();
         Scanner teclado = new Scanner(System.in);
         String comando="java Escribe";
         Process p,p1;
         try{
             p=r.exec(comando);
 //            p1=r.exec("notepad");
             
             PrintWriter pw = new PrintWriter(p.getOutputStream());
              String linea;
             
             do {
                 System.out.println("introduce un valor");
                 pw.println(teclado.nextInt());
                 pw.flush();
                 BufferedReader br = new BufferedReader(
                         new InputStreamReader(p.getInputStream()));
                
                 if((linea=br.readLine())!=null) System.out.println(linea);
             }while (!linea.equals("0"));
 //            System.out.println("Calculadora en marcha");
 //            System.out.println("Deseas finalizar la calculadora?");
 //            String respuesta = teclado.next();
 //            if (respuesta.equalsIgnoreCase("Si")) p.destroy();
 //            System.out.println("Continuando");
         }catch(Exception e){
             System.out.println("Error en:" + comando);
             e.printStackTrace();
         }
         
     }
 }