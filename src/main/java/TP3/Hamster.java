/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

/**
 *
 * @author hamst
 */
public class Hamster implements Runnable {
    String nombre;
    Jaula jaula;
    
    public Hamster(String nombre, Jaula jaula) {
        this.nombre = nombre;
        this.jaula = jaula;
    }
    
    public String getName() {
        return nombre;
    }
    public static void main(String[] args) {
        Jaula jaula = new Jaula(3);
        Hamster gloria = new Hamster("gloria", jaula);
        Hamster juan = new Hamster("juan", jaula);
        Hamster agustin = new Hamster("agustin", jaula);
        
        Thread th1 = new Thread(gloria);
        Thread th2 = new Thread(juan);
        Thread th3 = new Thread(agustin);
        th1.start();
        th2.start();
        th3.start();
    }

    @Override
    public void run() {
        try {
            this.jaula.usarHamaca(this);
            this.jaula.usarPlato(this);
            this.jaula.usarRueda(this);
        }
        catch (InterruptedException e) {
            System.out.println("ERROR");
        }

    }
}
