
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Practica1_2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Introduce la cantidad de números a generar (0 para salir): ");
            try {
                String input = reader.readLine();
                int cantidad = Integer.parseInt(input);

                if (cantidad == 0) {
                    System.out.println("Saliendo del programa...");
                    break;
                } else if (cantidad < 0) {
                    System.err.println("Error: La cantidad debe ser un número positivo o 0.");
                    continue;
                }

                // Ejecutar aleatorios.java y ordenar.java usando ProcessBuilder
                ejecutarProcesosConectados(cantidad);

            } catch (NumberFormatException e) {
                System.err.println("Error: Introduce un número válido.");
            } catch (IOException e) {
                System.err.println("Error de E/S: " + e.getMessage());
            }
        }
    }

    private static void ejecutarProcesosConectados(int cantidad) {
        try {
            // Proceso para aleatorios.java
            ProcessBuilder pbAleatorios = new ProcessBuilder("java", "Aleatorios", String.valueOf(cantidad));
            
            // Proceso para ordenar.java
            ProcessBuilder pbOrdenar = new ProcessBuilder("java", "ordenarNumeros");
            
            // Redirigir la salida de aleatorios a la entrada de ordenar
            pbAleatorios.redirectOutput(ProcessBuilder.Redirect.PIPE);
            pbOrdenar.redirectInput(ProcessBuilder.Redirect.PIPE);
            
            // Redirigir la salida de ordenar a la consola
            pbOrdenar.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            
            // Iniciar los procesos
            Process procesoAleatorios = pbAleatorios.start();
            Process procesoOrdenar = pbOrdenar.start();
            
            InputStream emisorOutput = procesoAleatorios.getInputStream();
            OutputStream receptorInput= procesoOrdenar.getOutputStream();

            emisorOutput.transferTo(receptorInput);
            receptorInput.close();

            // Esperar a que ambos procesos terminen
            int exitCodeAleatorios = procesoAleatorios.waitFor();
            int exitCodeOrdenar = procesoOrdenar.waitFor();
            
            if (exitCodeAleatorios != 0 || exitCodeOrdenar != 0) {
                System.err.println("Error: Alguno de los procesos falló.");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar los procesos: " + e.getMessage());
        }
    }

}
