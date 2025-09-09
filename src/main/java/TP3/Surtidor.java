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
public class Surtidor {
    int combustibleMaximo;
    int combustible;
    String nombre;
    
    public Surtidor(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.combustibleMaximo = combustible;
    }
    
    public synchronized boolean cargarNafta(Auto unAuto) {
        System.out.println(unAuto.getPatente() + "Esta cargando nafta");
        int recargar = unAuto.getCombustibleMaximo();
        boolean resultado = true;
        if (combustibleMaximo == 0) {
            resultado = false;
        }
        else if (recargar >= combustible) {
            unAuto.recargarCombustible(combustible);
            combustibleMaximo = 0;
        }
        else {
            unAuto.recargarCombustible(recargar);
            combustibleMaximo -= recargar;
        }
        return resultado;
        
    }
    
    public void simularAutos(Auto[] autos, int iteraciones) {
        for (int i = 0; i < iteraciones; i++) {
            for (Auto auto:autos) {
                if (!auto.andar(1)) {
                    cargarNafta(auto);
                }
            }
        }
    }
    public static void main(String[] args) {
        Auto uno = new Auto("auto1","auto1","auto1",0,10);
        Auto dos = new Auto("auto2","auto2","auto2",0,10);
        Auto[] autos = {uno,dos};
        Surtidor ypf = new Surtidor("ypf",15);
        ypf.simularAutos(autos,20);
    }
}
