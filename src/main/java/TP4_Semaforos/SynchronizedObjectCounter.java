/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos;

/**
 *
 * @author hamst
 */
public class SynchronizedObjectCounter {

    public SynchronizedObjectCounter() {
        
    }
    
    private Integer c = 0;

    public void increment() {
        synchronized (c) {
            c++;
        } // Este elemento debe ser casteado a integer
    }

    public void decrement() {
        synchronized (this) {
            c--;
        }
    }

    public int value() {
        return c;
    }
}
