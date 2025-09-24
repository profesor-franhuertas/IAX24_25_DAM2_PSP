import java.util.Random;

public class Aleatorios {
    public static void main(String[] args) {
        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();

        // Definir la cantidad de números aleatorios a generar
        int cantidadNumeros = 40;

        // Generar y escribir los números aleatorios
       // System.out.println("Generando " + cantidadNumeros + " números aleatorios entre 0 y 100:");

        for (int i = 0; i < cantidadNumeros; i++) {
            // Generar un número aleatorio entre 0 y 100 (inclusive)
            int numeroAleatorio = random.nextInt(101);

            // Escribir el número en la salida estándar
            System.out.println(numeroAleatorio);
        }
    }
}

