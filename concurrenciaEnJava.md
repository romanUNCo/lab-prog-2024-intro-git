# Concurrencia en Java - Introducción
Los semáforos son un mecanismo de sincronización en Java que se utiliza para controlar el acceso a recursos compartidos. Un `Semaphore` mantiene un contador que permite gestionar la cantidad de permisos disponibles para los hilos que intentan acceder al recurso. 

A diferencia de `synchronized` y `Lock`, un semáforo puede permitir que varios hilos accedan simultáneamente a un recurso limitado, dependiendo del número de permisos configurados. Es particularmente útil en escenarios donde se debe controlar el acceso concurrente a un conjunto limitado de recursos.

# Guía de Uso
Para utilizar un semáforo (`Semaphore`) en Java, primero debes importar la clase correspondiente desde el paquete `java.util.concurrent`. A continuación, se muestra un ejemplo básico de cómo utilizar un `Semaphore`:

```java
import java.util.concurrent.Semaphore;

public class EjemploSemaforo {
    private final Semaphore semaforo = new Semaphore(3); // Permitir hasta 3 accesos simultáneos

    public void accederRecurso() {
        try {
            semaforo.acquire(); // Adquirir un permiso
            // Código que accede al recurso compartido
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaforo.release(); // Liberar el permiso
        }
    }
}