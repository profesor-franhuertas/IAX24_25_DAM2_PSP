import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Orquestador {
    public static void main(String[] args) throws Exception{

        // Crear el primer proceso (Emisor)
        ProcessBuilder pb1 = new ProcessBuilder("java","Emisor.java");
        pb1.redirectErrorStream(true);
        Process p1 = pb1.start();

        // Crear el segundo proceso (Receptor)
        ProcessBuilder pb2 = new ProcessBuilder("java","Receptor.java");
        pb2.redirectErrorStream(true);
        Process p2 = pb2.start();

        // Obtener streams de entrada/salida
        OutputStream os2 = p2.getOutputStream();
        InputStream is1 = p1.getInputStream();
        InputStream is2 = p2.getInputStream();

        // Leer mensaje del Emisor
        BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
        String mensajeEmisor = br1.readLine();
        System.out.println("Proceso principal recibió del Emisor: " + mensajeEmisor);

        // Enviar mensaje del Emisor al Receptor
        PrintWriter pw = new PrintWriter(os2);
        pw.println(mensajeEmisor);
        pw.flush();

        // Leer respuesta del Receptor
        BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
        String respuestaReceptor = br2.readLine();
        System.out.println("Proceso principal recibió del Receptor: " + respuestaReceptor);

        // Cerrar streams y procesos
        pw.close();
        br1.close();
        br2.close();
        p1.destroy();
        p2.destroy();
    
    }
}
