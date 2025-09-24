/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Fran
 */
public class Ejemplo2 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando= "CMD /C DIR";
        Process p = null;
        try{
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //Comprobación del error
        int exitVal;
        try {
            exitVal=p.waitFor();
            System.out.println("Valor de salida " + exitVal);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
            
}
