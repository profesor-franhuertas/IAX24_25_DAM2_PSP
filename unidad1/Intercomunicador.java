import java.io.InputStream;
import java.io.OutputStream;


public class Intercomunicador {
    public static void main(String[] args) throws Exception {
        // Crear ProcessBuilder para Emisor y Receptor
        ProcessBuilder pbEmisor = new ProcessBuilder("java", "Emisor.java");
        ProcessBuilder pbReceptor = new ProcessBuilder("java", "Receptor.java");

        // Configurar redirecciones
        pbEmisor.redirectOutput(ProcessBuilder.Redirect.PIPE);
        pbReceptor.redirectInput(ProcessBuilder.Redirect.PIPE);
        pbReceptor.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        // Iniciar procesos
        Process pEmisor = pbEmisor.start();
        Process pReceptor = pbReceptor.start();

        // Conectar la salida del Emisor con la entrada del Receptor
        InputStream emisorOutput = pEmisor.getInputStream();
        OutputStream receptorInput = pReceptor.getOutputStream();

        emisorOutput.transferTo(receptorInput);
        receptorInput.close();

        // Esperar a que los procesos terminen
        int exitCodeEmisor = pEmisor.waitFor();
        int exitCodeReceptor = pReceptor.waitFor();

        System.out.println("Proceso Emisor terminó con código: " + exitCodeEmisor);
        System.out.println("Proceso Receptor terminó con código: " + exitCodeReceptor);
    }
}
