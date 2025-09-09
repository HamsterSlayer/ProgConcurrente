/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

/**
 *
 * @author hamst
 */
public class Vehiculo {

    int km;
    int combustible;
    int combustibleMaximo;
    
    public Vehiculo(int km, int combustible) {
        this.km = km;
        this.combustible = combustible;
        this.combustibleMaximo = combustible;
    }
    
    public int getCombustibleMaximo() {
        return combustibleMaximo;
    }
}
