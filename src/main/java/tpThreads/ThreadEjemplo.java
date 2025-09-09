/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpThreads;

/**
 *
 * @author hamst
 */
public class ThreadEjemplo extends Thread {

    public ThreadEjemplo(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) {
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }
    
    //Ejecutarlo varias veces nos muestra como el planificador de procesos funciona, dandole de forma alternada tiempo a los hilos.
    //Esto también demuestra que el planificador le da a los hilos  tiempos diferentes dependiente de varios factores.
}
