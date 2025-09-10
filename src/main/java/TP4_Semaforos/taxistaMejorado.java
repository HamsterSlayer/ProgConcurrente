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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class taxistaMejorado implements Runnable {

    Semaphore avisoMutuo;

    public taxistaMejorado(Semaphore avisoMutuo) {
        this.avisoMutuo = avisoMutuo;
    }

    @Override
    public void run() {
        while (true) {
            turno();
        }
    }

    private void turno() {
        if (avisoMutuo.availablePermits() == 1) {
            viajar();
        } else {
            dormir();
        }
    }

    private void esperar(long milis) {
        try {
            Thread.sleep(milis);

        } catch (InterruptedException ex) {
            System.out.println("ERROR ");
        }
    }
    
    private void dormir() {
        while(avisoMutuo.availablePermits() == 0) {
            System.out.println("El taxista esta durmiendo");
            esperar(500);
        }
    }
    
    private void viajar() {
        System.out.println("El taxista esta manejando");
        esperar(500);
        System.out.println("El taxista termino su viaje");
        try {
        avisoMutuo.acquire();
        }
        catch(InterruptedException e) {
            System.out.println("ERROR");
        }
    }
    
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(0);
        Thread taxista = new Thread(new taxistaMejorado(sem));
        Thread cliente = new Thread(new clienteMejorado(sem));
        taxista.start();
        cliente.start();
    }
}
