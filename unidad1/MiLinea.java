/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procesos;

/**
 *
 * @author fran
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author puche
 */
public class MiLinea {
    
    Process proceso;
    BufferedReader br;
    BufferedWriter bw;
    String lineaComandos;
    
    
    public boolean CreaProceso(){
       boolean error=false; 
       Runtime runtime = Runtime.getRuntime();
       String nombreSO = System.getProperty("os.name");
        System.out.println(nombreSO);
        if( nombreSO.toLowerCase().indexOf("windows")!=-1 ){
            lineaComandos="cmd";
        }else if( nombreSO.toLowerCase().indexOf("linux")!=-1 ){
           lineaComandos="term";
        }
        try {
            proceso = runtime.exec(lineaComandos);
            //br=new BufferedReader(new InputStreamReader (proceso.getInputStream()));
           // bw=new BufferedWriter(new OutputStreamWriter (proceso.getOutputStream()));
        } catch (IOException  ex) {
            System.out.println("ERROR DE E/S");
            error=true;
        }finally{
            return error;
        }
    }
    
    
    public boolean ejecutaComando(String comando){
        boolean error=false;
        try {
          //  this.CreaProceso();
            bw=new BufferedWriter(new OutputStreamWriter (proceso.getOutputStream()));
            PrintWriter pw = new PrintWriter(proceso.getOutputStream(),true);
            pw.write(comando+"\n\n");
            pw.close();
            //bw.flush();
           // bw.close();
        } catch (Exception ex) {
            error=true;
            System.out.println("Error de E/S");
        }finally{
            return error;
        }
    }
    
     public boolean pintaResultado(){
        String  linea;
        boolean error=false;
         try {
       //     proceso.waitFor();
             System.out.println(proceso.toString()+" "+proceso.exitValue());
            BufferedReader bri =new BufferedReader(new InputStreamReader (proceso.getInputStream()));
            while( (linea=bri.readLine())!=null){
                   System.out.println(linea);
            }
           // br.close();
        } catch (IOException ex) {
            error=true;
            System.out.println("Error de E/S");
        }finally{
             return error;
         }
     }
     
     public boolean cerrarProceso(){
        boolean error=false;
         try {
            br.close();
            bw.close();
            proceso.destroy();
        } catch (IOException ex) {
            error=true;
            System.out.println("Error de E/S");
        }finally{
             return error;
         }
     }
    public static void main(String[] args) {
        MiLinea lc = new MiLinea();
        lc.CreaProceso();
        lc.ejecutaComando("dir");
        lc.pintaResultado();
       
        lc.ejecutaComando("ipconfig");
      // lc.pintaResultado();
        lc.ejecutaComando("notepad");
        //lc.pintaResultado();
        lc.ejecutaComando("calc");
        lc.pintaResultado();
        
    }
    
    
}