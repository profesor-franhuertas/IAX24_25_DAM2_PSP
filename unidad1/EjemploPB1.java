/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fran
 */
public class EjemploPB1 {
    public static void main(String[] args) {
        ProcessBuilder test = new ProcessBuilder();
        Map entorno = test.environment();
        System.out.println("Variables de entorno");
        System.out.println(entorno);
        
        test = new ProcessBuilder("java", "UnSaludo", "\"Hola Mundo!!\"");
        
        //
        List l = test.command();
      
        Iterator iter = l.iterator();
        System.out.println("Argumentos del comando");
        while (iter.hasNext())
            System.out.println(iter.next());
        
        
        test = test.command("CMD", "/C", "DIR");
        try{
            Process p = test.start();
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
               
      
    }
}
