/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos;

/**
 *
 * @author hamst
 */
public class SynchronizedCounter {
    
    public SynchronizedCounter() {
        
    }
    
    private int c = 0;
    
public synchronized void increment() {
    c++;
}

public void decrement() {
    c--;
}

public synchronized int value() {
    return c;
}


    public static void main(String[] args) {
        SynchronizedCounter incisoA = new SynchronizedCounter();
        SynchronizedObjectCounter incisoB = new SynchronizedObjectCounter();
        
    }
}
