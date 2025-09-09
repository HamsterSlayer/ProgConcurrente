package tpThreads;

/**
 *
 * @author hamst
 */
public class ThreadRunnable implements Runnable {
    
    private String nombreHilo;
    public ThreadRunnable(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++)
    System.out.println(i + " " + nombreHilo);
    System.out.println("Termina thread " + nombreHilo);
    }
    
    public static void main (String [] args) {
        ThreadRunnable run1 = new ThreadRunnable("Maria Jose");
        ThreadRunnable run2 = new ThreadRunnable("Jose Maria");
        Thread nuevo = new Thread(run1);
        Thread nuevo2 = new Thread(run2);
        nuevo.start();
        nuevo2.start();
        System.out.println("Termina thread main");
    }
    
    //Para implementar runnable tengo que adoptar el run de forma obligatoria.
    //El uso del constructor es necesario si queremos pasarle algun parametro al run ya que el run no acepta metodos en sí
    
}
