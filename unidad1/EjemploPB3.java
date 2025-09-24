/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran
 */
public class EjemploPB3 {
     public static void main(String[] args) {
        ProcessBuilder pb  = new ProcessBuilder("CMD");
        
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");
        File fBat = new File("fichero.txt");
        
        pb.redirectError(fErr);
        pb.redirectOutput(fOut);
        pb.redirectInput(fBat);
         try {
             Process p =pb.start();
             p.waitFor();
             
         } catch (IOException | InterruptedException ex) {
            System.err.println(ex.getMessage());
             Logger.getLogger(EjemploPB3.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
}
