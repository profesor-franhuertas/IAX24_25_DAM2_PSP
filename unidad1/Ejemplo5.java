/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author Fran
 */
public class Ejemplo5 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
      
        String comando= "cmd /c date ";
        Process p=null;
        try {
            p= r.exec(comando);
            OutputStream os = p.getOutputStream();
            os.write("02-12-12".getBytes());
            os.flush();
         
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }          
            br.close();
        }catch(Exception e){
            
        }
    }
}
