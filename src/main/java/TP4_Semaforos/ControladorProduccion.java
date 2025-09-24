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
public class ControladorProduccion implements Runnable {
    ReentrantLock turno;
    int productoElec;
    int productoMec;
    int metaElec = 30;
    int metaMec = 30;
    boolean turnoElec;
    
    public ControladorProduccion() {
        turno = new ReentrantLock();
        productoElec = 0;
        productoMec = 0;
        turnoElec = true;
    }
    
    public ReentrantLock getLock() {
        return turno;
    }
    
    public boolean turnoMec() {
        return !turnoElec;
    }
    
    public boolean turnoElec() {
        return turnoElec;
    }
    private void cambiarTurno() {
         turnoElec = !turnoElec;
    }
    
    public boolean terminado(boolean esElec) {
        boolean resultado;
        if (esElec) {
           resultado = productoElec >= metaElec;
        }
        else {
           resultado = productoMec >= metaMec;
        }
        return resultado;
    }
    
    public void saleElec() {
        productoElec++;
    }
    
    public void saleMec() {
        productoMec++;
    }
    
    @Override
    public void run() {
        while(productoElec < metaElec || productoMec < metaMec) {
            try {
                turno.lock();
                try {
                    cambiarTurno();
                    System.out.println("Cambio turno");
                    
                    
                }
                finally {
                    turno.unlock();
                }
                Thread.sleep(200);
            }
            catch (InterruptedException ex) {
                System.getLogger(ControladorProduccion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        System.out.println("SE LLEGO a ELEC:" + productoElec + " Y MEC:" + productoMec);
        
    }
    
    public static void main(String[] args) {
        ControladorProduccion control = new ControladorProduccion();
        Thread th1 = new Thread(control);
        Thread th2 = new Thread(new lineaEnsamblaje(true,200,control));
        Thread th3 = new Thread(new lineaEnsamblaje(false,300,control));
        th1.start();
        th2.start();
        th3.start();
    }
}