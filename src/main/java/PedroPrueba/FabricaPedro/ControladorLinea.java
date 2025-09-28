package PedroPrueba.FabricaPedro;

public class ControladorLinea implements Runnable {
    private ControladorProduccion controladorProduccion;

    public ControladorLinea(ControladorProduccion controladorProduccion) {
        this.controladorProduccion = controladorProduccion;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(10000);
                controladorProduccion.necesitaCambiar();
                controladorProduccion.cambiarLinea();
                controladorProduccion.terminoCambiar();
                controladorProduccion.salir();
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
    }
}
