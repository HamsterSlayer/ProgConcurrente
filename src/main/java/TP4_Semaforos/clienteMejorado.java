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
/*
import java.util.concurrent.Semaphore;

/**
 *
 * @author alumno
 */
public class clienteMejorado implements Runnable {
    //El 0 significa que es su turno
    //Cuando el semaphore es 1, esta descansando
    Semaphore avisoMutuo;
    //Solo puede hacer un release para avisar que dejo de trabajar
    @Override
    public void run() {
        while(true) {
            turno();
        }
    }
    
    public clienteMejorado(Semaphore avisoMutuo) {
        this.avisoMutuo = avisoMutuo;
    }
    
    public void turno() {
        if (avisoMutuo.availablePermits() == 0) {
            buscarTaxi();
        }
        else {
            System.out.println("El cliente encontro taxista");
            esperaDeTaxista();
        }
    }
        private void esperar(long milis) {
        try {
            Thread.sleep(milis);

        } catch (InterruptedException ex) {
            System.out.println("ERROR ");
        }
    }
        
        private void esperaDeTaxista() {
            while (avisoMutuo.availablePermits() == 1) {
                System.out.println("Cliente esta viajando");
                esperar(200);
            }
        }
        
        private void buscarTaxi() {
                System.out.println(">> Cliente Esta buscando un Taxista <<");
                esperar(500);
                avisoMutuo.release();
        }
}
