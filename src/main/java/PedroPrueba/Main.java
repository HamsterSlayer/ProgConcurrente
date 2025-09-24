package PedroPrueba;

public class Main {
    public static void main(String[] args) {
        Energia nuevaEnergia = new Energia();
        String[] nombres = new String[] { "Sanador", "Criatura Oscura" };
        Modificador[] modificadores = new Modificador[] { new Modificador(3, nuevaEnergia),
                new Modificador(-3, nuevaEnergia) };
        Thread[] threads = new Thread[] { new Thread(modificadores[0], nombres[0]),
                new Thread(modificadores[1], nombres[1]) };
        for (Thread thread : threads) {
            thread.start();
        }
        // Puedo sincronizar dos clases diferentes???
        // Tendrian que ser subclases???
    }
}
