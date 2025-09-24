import java.io.File;

public class Main2 {
    public static void main(String[] args) {
        try {
            // Especifica el ejecutable (cmd.exe) y los argumentos que se pasan al
            // ejecutable (/C y dir): 
            ProcessBuilder builder = new ProcessBuilder("cmd.exe","/C", "dir");
            builder.directory(new File("C:\\TEMP\\"));
            // Especifica una variable de entorno y su valor:
            builder.environment().put("VAR_ENTORNO", "VALOR");
            Process process = builder.start();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}