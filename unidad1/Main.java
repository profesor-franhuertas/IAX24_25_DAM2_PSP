

public class Main {
    public static void main(String[] args) {
        
        try { // La instancia ProcessBuilder puede ser configurada con parámetros de
              // inicio del programa, como la ruta del ejecutable, argumentos y
              // opciones adicionales.
            ProcessBuilder builder = new ProcessBuilder("notepad.exe");
            Process process = builder.start();
            // Bloquea la ejecución del programa en este punto hasta que el proceso
            // finalice
            process.waitFor();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}