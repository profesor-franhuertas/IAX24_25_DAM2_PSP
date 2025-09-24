/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author profesor
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Interactua {
    Process process;
    public void ejecuta(String cmd){
        try {
            OutputStream os = process.getOutputStream();
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(os); 
            cmd=cmd+"\n";
            os.write(cmd.getBytes());
            os.flush();
           
            String linea;
            while((linea=br.readLine())!=null)
                    System.out.println(linea);
            process.waitFor();
        } catch (IOException ex) {
            Logger.getLogger(Interactua.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interactua.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) throws IOException {
//        if (args.length <= 0) {
//            System.err.println("Se necesita un programa a ejecutar");
//            System.exit(-1);
//        }
        Scanner teclado = new Scanner(System.in);
        String comando;
        ProcessBuilder pb = new ProcessBuilder("cmd ");
        
        Interactua it = new Interactua();
        try {
            it.process = pb.start();
            
            do {
                System.out.println("Introduce comando: ");
                comando=teclado.nextLine();  
                it.ejecuta(comando);
                
            }while (comando.compareToIgnoreCase("fin")!=0);
        }catch(IOException ex){
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}