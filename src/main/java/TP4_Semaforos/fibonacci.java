/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos;

/**
 *
 * @author hamst
 */
public class fibonacci {
    public static void main(String[] args) {
        int resultado = fibonacci(5);
        System.out.println(resultado);
    }
    
    static int fibonacci(int posicion) {
        int resultado = -1;
        //Caso Base
        if (posicion == 0) {
            resultado = 1;
        }
        else if (posicion == 1) {
            resultado = 1;
        }
        //Caso Recursivo
        else {
            //f(n) = f(n-1) + f(n-2)
            resultado = fibonacci(posicion-1) + fibonacci(posicion-2);
        }
        return resultado;
    }
    
}
