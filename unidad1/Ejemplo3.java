/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Fran
 */
public class Ejemplo3 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando= "java UnSaludo \"Hola Mundo!!\" ";
       //  String comando= "cmd /c dir ";
        Process p=null;
       if (args.length < 1) {
            System.out.println("SE NECESITA UN FICHERO");
            System.exit(1);
        }        
       try{
           FileOutputStream fos = new FileOutputStream(args[0]);
           PrintWriter pw = new PrintWriter(fos);
           p = r.exec(comando);
             InputStream is = p.getInputStream();
             
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println("Inserto en "+ args[0] +" > " +linea);
                pw.println(linea);
            }
            br.close();   
            pw.close();
        
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}
