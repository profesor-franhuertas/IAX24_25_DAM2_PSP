package Ejemplos.Unidad1;

public class EjemploRuntime {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Precesadores:" + rt.availableProcessors() 
            + " Memoria: " + rt.freeMemory() );
    }
}
