import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Receptor {
    public static void main(String[] args) throws Exception {
        // Lee el mensaje y responde
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mensaje = br.readLine();
        System.out.println("Proceso 2 recibió: " + mensaje);
        System.out.println("Hola desde el proceso 2");
    }
}
