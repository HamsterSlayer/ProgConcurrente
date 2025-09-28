package PedroPrueba.FabricaPedro;

public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[19];
        ControladorProduccion controladorProduccion = new ControladorProduccion();
        threads[0] = new Thread(new ControladorLinea(controladorProduccion));
        for (int i = 1; i < threads.length; i++) {
            if (i < 10) {
                threads[i] = new Thread(new Producto("Electrico", controladorProduccion));
            } else {
                threads[i] = new Thread(new Producto("Mecanico", controladorProduccion));
            }
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }
}