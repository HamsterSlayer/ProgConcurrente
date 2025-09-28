package PedroPrueba.FabricaPedro;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {
    private boolean electrico = true;
    private boolean ocupado = false;
    private boolean cambiaLinea = false;
    private Semaphore entradaElectrico = new Semaphore(1);
    private Semaphore entradaMecanico = new Semaphore(0);
    private Semaphore cambioLinea = new Semaphore(0);

    public ControladorProduccion() {

    }

    public boolean getElectrico() {
        return electrico;
    }

    public void ocupar() {
        System.out.println("LÍNEA DE PRODUCCIÓN OCUPADA");
        ocupado = true;
    }

    public void desocupar() {
        System.out.println("LÍNEA DE PRODUCCIÓN DESOCUPADA");
        ocupado = false;
    }

    public void necesitaCambiar() {
        cambiaLinea = true;
    }

    public void terminoCambiar() {
        cambiaLinea = false;
    }

    public void cambiarLinea() throws InterruptedException {
        cambioLinea.acquire();
        System.out.println("*** CAMBIANDO DE LINEA ***");
        if (electrico) {
            electrico = false;
        } else {
            electrico = true;
        }

    }

    public void salir() {
        if (cambiaLinea) {
            cambioLinea.release();
        } else {
            if (electrico) {
                entradaElectrico.release();
            } else {
                entradaMecanico.release();
            }
        }
    }

    public void llegaMecanico() throws InterruptedException {
        entradaMecanico.acquire();
        ocupar();
        System.out.println("Ensamblando un producto mecanico. . .");
        Thread.sleep(2000);
        System.out.println("Producto mecanico ensamblado");
    }

    public void llegaElectrico() throws InterruptedException {
        entradaElectrico.acquire();
        ocupar();
        System.out.println("Ensamblando un producto electrico. . .");
        Thread.sleep(2000);
        System.out.println("Producto electrico ensamblado");
    }
}
