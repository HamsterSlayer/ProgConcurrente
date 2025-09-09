/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

/**
 *
 * @author hamst
 */
public class Auto extends Vehiculo {
    String modelo;
    String patente;
    String marca;
    public Auto(String patente, String modelo, String marca, int km, int combustible) {
        super(km,combustible);
        this.modelo = modelo;
        this.patente = patente;
        this.marca = marca;
    }
    
    public boolean andar(int kilometros) {
        boolean resultado = true;
        
        if (combustible <= 0) {
            resultado = false;
            System.out.println("El auto con patente: " + patente + "se quedo sin combustible");
        }
        else if (combustible < kilometros) {
            km += combustible;
            System.out.println("El auto con patente: " + patente + "anduvo: " + combustible);
            combustible = 0;
             
        }
        else {
            combustible -= kilometros;
            km += kilometros;
            System.out.println("El auto con patente: " + patente + "anduvo: " + kilometros);
        }
        return resultado;
    }
    
    public void recargarCombustible(int nafta) {
        if (nafta >= combustibleMaximo) {
            combustible = combustibleMaximo;
        }
        else {
            combustible += nafta;
        }
        System.out.println("El auto con patente: " + patente + "recargo combustible");
    }
    
    public String getPatente() {
        return this.patente;
    }
}
