import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class LanzaProcesoEscribeAEntrada {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("nslookup");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try(InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
            BufferedReader br = new BufferedReader(isr)){
                String linea;
                System.out.println("Introduce nombre del dominio: ");
                while ((linea=br.readLine())!=null && linea.length()!=0) {
                    Process ps =pb.start();
                    //Try con recursos para que se llame de forma automática el método close y no usar la clausula finally
                    try( OutputStream os = ps.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8")){
                        osw.write(linea);
                    }
                    try {
                        ps.waitFor();
                    }catch(InterruptedException ex){

                    }
                    System.out.println("Introduce nombre del dominio: ");
                }

        }catch (Exception e){
            System.out.println("Error de ES");
            e.printStackTrace();
        }
    }
}
