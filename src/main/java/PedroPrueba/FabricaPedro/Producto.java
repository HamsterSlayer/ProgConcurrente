package PedroPrueba.FabricaPedro;

public class Producto implements Runnable {
    private String categoria;
    private ControladorProduccion controladorProduccion;

    public Producto(String categoria, ControladorProduccion controladorProduccion) {
        this.categoria = categoria;
        this.controladorProduccion = controladorProduccion;
    }

    public void run() {
        try {
            // Espera un tiempo para simular andar por el bus mecanico
            Thread.sleep(500);
            if (categoria.equals("Electrico")) {
                controladorProduccion.llegaElectrico();
                controladorProduccion.desocupar();
                Thread.sleep(1000);
            } else {
                controladorProduccion.llegaMecanico();
                controladorProduccion.desocupar();
                Thread.sleep(1000);
            }
            controladorProduccion.salir();

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}