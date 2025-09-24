package Synchronized.ej7;

public class Impresor implements Runnable {
    private char letra;
    private int cantVeces;
    private Controlador controlador;

    public Impresor(char letra, Controlador controlador, int cantVeces) {
        this.letra = letra;
        this.controlador = controlador;
        this.cantVeces = cantVeces;
    }

    public void run() {
        try {
            while (cantVeces > 0) {
                if (controlador.obtenerPermiso(letra)) {
                    System.out.print(letra);
                    cantVeces--;
                    Thread.sleep(500);
                } else {
                    Thread.sleep(1000);
                }
            }
            controlador.incrementarEstado();
        } catch (InterruptedException e) {
            System.out.println("Estátua de Gaturro hecha pelota");
        }
    }

}
