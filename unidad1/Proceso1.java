import java.io.IOException;

public class Proceso1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process ps = Runtime.getRuntime().exec("notepad.exe");
        System.out.println((ps.isAlive())?"Está vivo":"Está muerto");
        ps.destroy();
        ps.waitFor();
        System.out.println((ps.isAlive())?"Está vivo":"Está muerto");
    }
}