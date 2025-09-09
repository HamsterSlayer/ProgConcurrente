/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

/**
 *
 * @author hamst
 */
public class Heroe {
    private String nombre;
    private int vida;
    private int energia;

    public Heroe(String nombre, int vida, int energia) {
        this.nombre = nombre;
        this.vida = vida;
        this.energia = energia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEnergia() {
        return energia;
    }
    
    public synchronized int restarEnergia(int energiaTomada) {
        
        int devuelto;
        if (energia <= 0) {
            devuelto = 0;
            System.out.println("Hay cero de energia");
        }
        else if (energia < energiaTomada) {
            devuelto = energia;
            System.out.println("Se resto: " + devuelto);
            energia = 0; 
        }
        else {
            devuelto = energiaTomada;
            energia -= energiaTomada;
            System.out.println("Se resto: " + energiaTomada);
        }
        
        return devuelto;
    }
    
    public synchronized boolean agregarEnergia(int energiaDada) {
        boolean resultado;
        if (energia <= 0) {
            resultado = false;
            System.out.println("No se puede agregar mas energia porque esta en cero");
        }
        else {
            resultado = true;
            System.out.println("Se agrego: " + energiaDada);
            energia += energiaDada;
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        Heroe gloria = new Heroe("Gloria",100,10);
        CriaturaOscura agustin = new CriaturaOscura(0,3,gloria);
        Sanador juan = new Sanador(3,3,gloria);
        Thread th1 = new Thread(agustin);
        Thread th2 = new Thread(juan);
        th2.start();
        th1.start();
        
    }
    
    
    
}
