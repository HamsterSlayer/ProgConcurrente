/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author hamst
 */
public class lineaEnsamblaje implements Runnable {

    boolean esElec;
    long tiempoEnsamblaje;
    ControladorProduccion control;
    ReentrantLock lock;
    int pila = 0;

    public lineaEnsamblaje(boolean esElec, long tiempoEnsamblaje, ControladorProduccion control) {
        this.esElec = esElec;
        this.tiempoEnsamblaje = tiempoEnsamblaje;
        this.control = control;
        lock = control.getLock();
    }

    @Override
    public void run() {
        while (!control.terminado(esElec)) {

            try {
                if (lock.tryLock()) {
                    if (esElec && control.turnoElec && pila >= 0) {
                        //Electrico
                        try {
                            System.out.println("Sale Elec");
                            control.saleElec();
                            pila--;
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {

                        }
                    } else if (!esElec && control.turnoMec() && pila >= 0) {
                        //Mecanico
                        System.out.println("Sale mec");
                        try {
                            control.saleMec();
                            pila--;
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {

                        }
                    } else {
                        System.out.println("A construir");
                        construir();
                    }
                    lock.unlock();
                }
            } catch (Exception e) {
                System.out.println("EXPLOTO EL ENSAMBLAJE");
            }

        }
    }

    private void construir() {
        try {
            Thread.sleep(tiempoEnsamblaje);
        } catch (InterruptedException ex) {
            System.out.println("HOLA");
        }
        pila++;
    }
}
