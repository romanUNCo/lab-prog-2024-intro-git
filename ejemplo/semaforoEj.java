import java.util.concurrent.Semaphore;

public class semaforoEj {
    private final Semaphore semaforo = new Semaphore(3);

    public void accesoRecurso(int id) {
        try {
            System.out.println("El hilo " + id + " está esperando un permiso.");
            semaforo.acquire();
            System.out.println("El hilo " + id + " ha adquirido un permiso.");
            
            // Simula acceso al recurso
            Thread.sleep(2000);

            System.out.println("El hilo " + id + " ha liberado el permiso.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaforo.release();
        }
    }

    public static void main(String[] args) {
        semaforoEj ejemplo = new semaforoEj();

        for (int i = 1; i <= 5; i++) {
            int id = i;
            new Thread(() -> ejemplo.accesoRecurso(id)).start();
        }
    }
}