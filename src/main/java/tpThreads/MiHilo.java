
package tpThreads;

/**
 *
 * @author hamst
 */
public class MiHilo implements Runnable {
    String unHilo;
    
    public MiHilo(String nombre) {
        unHilo = nombre;
    }
    
    @Override
        public void run() {
           System.out.println("Comenzando "+ unHilo);
        try {
        for (int contar=0; contar<10; contar++){
            Thread.sleep(400);
            System.out.println("En "+ unHilo +", el recuento "+contar);
        }
        }catch (InterruptedException exc){
            System.out.println(unHilo + "Interrumpido.");
        }
            System.out.println("Terminando "+ unHilo);

        }
        
        
        
}
