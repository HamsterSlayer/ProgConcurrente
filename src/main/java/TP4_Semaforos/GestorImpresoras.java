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
        //Se puede hacer varios semaforos binarios para pensar que cada uno es una impresora
        //Tambien se puede hacer un semaforo con muchos permisos
        impresoras = new Semaphore[numImpresoras];
        
        for (int i = 0; i < impresoras.length; i++) {
            impresoras[i] = new Semaphore(1);
        }
    }
    
        
    public boolean adquirirImpresora(int numImpresora) {
        //Verifico que la posicion sea correcta
        if (numImpresora >= 0 && numImpresora < impresoras.length) {
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
    
    public int getNumImpresoras() {
        return impresoras.length;
    }
    public static void main(String[] args) {
        GestorImpresoras copychow = new GestorImpresoras(5);
        Cliente[] clientes = new Cliente[10];
        Thread[] colTh = new Thread[clientes.length];
        
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(copychow);
        }        
        for (int i = 0; i < clientes.length; i++) {
            colTh[i] = new Thread(clientes[i]);
        }
        
        for (Thread th: colTh) {
            th.start();
        }
        
    }

}

class Cliente implements Runnable {
    static int numPersonal = 0;
    int numCliente;
    final int  duracionImpresion;
    boolean tieneImpresora;
    GestorImpresoras local;
    
    public Cliente(GestorImpresoras local) {
        numPersonal++;
        numCliente = numPersonal;
        tieneImpresora = false;
        Random num = new Random();
        this.duracionImpresion = num.nextInt(0,301);
        this.local = local;
    }
    
    @Override
    public void run() {
        //guardare aqui el numeroDeImpresora
        int numImpresora = -1;
        
        //Busco una impresora
        while (!tieneImpresora) {
            //No dejare de buscar hasta encontrar una
            for (int i = 0; i < local.getNumImpresoras() && !tieneImpresora; i++) {
                
            tieneImpresora = local.adquirirImpresora(i);
            //Si adquiero una impresora entonces la guardo
            if (tieneImpresora) {
                numImpresora = i;
            }
            }
            if (!tieneImpresora) {
                
                System.out.println("Cliente numero: " + numCliente + "No ha conseguido impresora");
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    System.out.println("ERROR");
                }
            }
        }
        
        //Una vez tengo una impresora procedo a usarla
        try {
            System.out.println("Cliente numero: " + numCliente + "Esta usando la impresora: " + numImpresora);
            Thread.sleep(duracionImpresion);
        }
        catch(InterruptedException e) {
            System.out.println("ERROR");
        }
        
        //Una vez termino, libero la impresora
        local.liberarImpresora(numImpresora);
        System.out.println("Cliente numero: " + numCliente + "Termino de usar la impresora num:" + numImpresora);
    }
    
    
}