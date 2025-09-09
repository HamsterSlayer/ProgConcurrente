package TP4_Semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author hamst
 */
public class ejercicioTres {
    
    public static void main(String[] args) {
        Semaphore p1 = new Semaphore(0);
        Semaphore p2 = new Semaphore(0);
        Semaphore p3 = new Semaphore(1);
        //P1 -> P3 -> P2 -> P1...
        imprimeTexto t1 = new imprimeTexto("p1", 100, p3,p1);
        imprimeTexto t2 = new imprimeTexto("p2", 100, p1,p2);
        imprimeTexto t3 = new imprimeTexto("p3", 100, p2,p3);
        
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        
        try {
            th1.start();
            th2.start();
            th3.start();
        }
        catch(Exception e) {
            System.out.println("ERROR");
        }
        
    }
    
    
}
