
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ordenarNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numeros = new ArrayList<>();

        // System.out.println("Introduce los números (uno por línea). Presiona Ctrl+D
        // (Unix/Linux) o Ctrl+Z (Windows) seguido de Enter para finalizar la
        // entrada:");

        // Leer números de la entrada estándar
        while (scanner.hasNextDouble()) {
            double numero = scanner.nextDouble();
            numeros.add(numero);
        }

        // Ordenar los números
        Collections.sort(numeros);

        // Mostrar los números ordenados
        System.out.println("\nNúmeros ordenados:");
        for (Double numero : numeros) {
            System.out.println(numero);

        }

        scanner.close();
    }
}
