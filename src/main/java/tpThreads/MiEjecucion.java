/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpThreads;

/**
 *
 * @author hamst
 */
public class MiEjecucion extends Thread {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread miHilo = new MiEjecucion();
            miHilo.start();
            try {
                miHilo.join(); //Join se asegura de esperar a que termine para que siempre sea de forma lineal el resultado.
                System.out.println("En el main");
            }
            catch(Exception e) {
                
            }
            
        }

    }

    public void run() {
        ir();
    }

    public void ir() {
        hacerMas();
    }

    public void hacerMas() {
        System.out.println("En la pila");
    }
}
