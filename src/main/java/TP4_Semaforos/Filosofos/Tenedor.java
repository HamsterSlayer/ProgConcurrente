/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos.Filosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author hamst
 */
public class Tenedor {
    Semaphore semaforo;
    
    public Tenedor() {
        semaforo = new Semaphore(1);
    }
    
    public boolean tomarTenedor() {
        return semaforo.tryAcquire();
    }
    
    public boolean liberarTenedor() {
        semaforo.release();
        System.out.println(semaforo.availablePermits());
        return true;
    }
}
