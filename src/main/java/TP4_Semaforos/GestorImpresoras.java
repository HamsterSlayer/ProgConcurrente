/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author hamst
 */
public class GestorImpresoras {
    Semaphore[] impresoras;
    
    public GestorImpresoras(int numImpresoras) {
        impresoras = new Semaphore[numImpresoras];
        
        for (int i = 0; i < impresoras.length; i++) {
            impresoras[i] = new Semaphore(1);
        }
    }
    
        
    public boolean adquirirImpresora(int numImpresora) {
        //Verifico que la posicion sea correcta
        if (numImpresora >= 0 || numImpresora < impresoras.length) {
            //Devuelve el resultado de TryAcquire
            return impresoras[numImpresora].tryAcquire();
        }
        else {
            //Si la posicion esta fuera del array siempre es falso
            return false;
        }
    }
    
    public void liberarImpresora(int numImpresora) {
        //Verifico que la posicion sea correcta
        if ( (numImpresora >= 0 || numImpresora < impresoras.length) && impresoras[numImpresora].availablePermits() < 1) {
            impresoras[numImpresora].release();
        }
    }
    
    
    public static void main(String[] args) {
        GestorImpresoras copychow = new GestorImpresoras(5);
        Cliente[] clientes = new Cliente[50];
        
    }

}

class Cliente implements Runnable {
    final int  duracionImpresion;
    boolean tieneImpresora;
    
    public Cliente() {
        tieneImpresora = false;
        Random num = new Random();
        this.duracionImpresion = num.nextInt(0,301);
    }
    
    @Override
    public void run() {
        while (!tieneImpresora) {
            
        }
    }
    
    
}
