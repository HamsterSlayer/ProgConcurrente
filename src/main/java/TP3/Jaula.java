/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

import java.util.Random;

/**
 *
 * @author hamst
 */
public class Jaula {
    int capacidad;
    
    final Object rueda = new Object();
    final  Object plato = new Object();
    final Object hamaca = new Object();
    
    public Jaula(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public void usarRueda(Hamster hamster) throws InterruptedException {
        synchronized (rueda) {
            System.out.println(hamster.getName() + " esta usando la rueda");
            Thread.sleep(1000);
            System.out.println(hamster.getName() + " termino de usar la rueda");
        }
    }
    
    public void usarPlato(Hamster hamster) throws InterruptedException {
                synchronized (plato) {
            System.out.println(hamster.getName() + " esta usando el plato");
            Thread.sleep(2000);
            System.out.println(hamster.getName() + " termino de usar el plato");
        }
    }
    
    public void usarHamaca(Hamster hamster) throws InterruptedException {
                synchronized (hamaca) {
            System.out.println(hamster.getName() + " esta usando la hamaca");
            Thread.sleep(5000);
            System.out.println(hamster.getName() + " termino de usar la hamaca");
        }
    }
}
