package Synchronized.ej7;

public class Controlador {
    private char[] estados = { 'A', 'B', 'C' };
    private int estado = 0;

    public Controlador() {

    }

    public synchronized boolean obtenerPermiso(char letra) {
        return (estados[estado] == letra);
    }

    public synchronized void incrementarEstado() {
        estado++;
    }
}
