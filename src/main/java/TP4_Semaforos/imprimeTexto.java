/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author hamst
 */
public class imprimeTexto implements Runnable {
    String text;
    long duration;
    Semaphore sem;
    Semaphore sem2;
    
    public imprimeTexto(String text, long duration, Semaphore sem, Semaphore sem2){
        this.text = text;
        this.duration = duration;
        this.sem = sem;
        this.sem2 = sem2;
    }

    @Override
    public void run() {
        while (true) {
        if (sem.tryAcquire()) {
        try {
            System.out.println(text + " esta ejecutandose");
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
        sem2.release();
        System.out.println(text + " termino");
        }
        else {
                
                }
    }
        
    }
}
