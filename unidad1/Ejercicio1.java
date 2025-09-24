import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder builder = new ProcessBuilder("powershell.exe", 
        "-Command", "Get-FileHash .\\fichero.txt -Algorithm MD5 | Format-List");
      try{
            Process p = builder.start();
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
