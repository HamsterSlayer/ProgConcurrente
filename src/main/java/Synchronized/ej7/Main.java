package Synchronized.ej7;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        char[] letras = { 'A', 'B', 'C' };
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Impresor(letras[i], controlador, i + 3));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
