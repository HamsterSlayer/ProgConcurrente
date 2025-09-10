/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos;

/**
 *
 * @author hamst
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.Semaphore;


public class confiteria {
    
    Semaphore lugar; //1 vacio / 0 ocupado
    Semaphore comida; //0 noLista / 1 comidaLista
    
    public confiteria() {
        this.lugar = new Semaphore(1);
        this.comida = new Semaphore(0);
    }
    
    public boolean ocupar() {
        return this.lugar.tryAcquire();
    }
    
    public void desocupar() {
        if (lugar.availablePermits() == 0 && comida.availablePermits() == 1) {
            this.lugar.release();
            try {
                this.comida.acquire();
            }
            catch(InterruptedException e) {
                System.out.println("INTERRUPTED");
            }
        }
    }
    
    public void comidaLista() {
        
    }
}
