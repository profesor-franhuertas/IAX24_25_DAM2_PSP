/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franhuertas
 */
public class MSDOS {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p=null;
        try {
            p = r.exec("cmd /c dir");
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while((linea = br.readLine())!=null)
                System.out.println(linea);
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(MSDOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        int vRet = p.exitValue();
        System.out.println("El proceso acabo con "+vRet);
    }
}
