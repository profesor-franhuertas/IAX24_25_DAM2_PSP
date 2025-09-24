import java.util.stream.Stream;

public class Main3 {
public static void main(String[] args)
{
// Obtiene una colección de instancias Process representando todos los
// procesos actualmente en ejecución en el sistema:
Stream<ProcessHandle> procesos = ProcessHandle.allProcesses();
// Convierte la colección de objetos ProcessHandle en una lista, para poder
// recorrerla en un bucle:
for (ProcessHandle proceso in procesos.toList())
{
System.out.println("ID: " + proceso.pid());
System.out.println("Ruta del ejecutable: " + proceso.info().command());
System.out.println("---------------");
}
}
}