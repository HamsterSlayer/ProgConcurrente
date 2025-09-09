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
public class arregloSeis implements Runnable{
    int numeroThreads;
    final int[] arreglo;
    int [] resultado;
    
    public arregloSeis (int[] arreglo, int numeroThreads) {
        this.arreglo = arreglo;
        this.numeroThreads = numeroThreads;
        this.resultado = new int[] {0};
    }
    
    @Override
    public void run() {
        Thread[] colThread = new Thread[numeroThreads];
        for (int i = 0; i < colThread.length; i++) {
            colThread[i] = new Thread( new sumador(arreglo, i,resultado, numeroThreads));
        }
        for (Thread proceso: colThread) {
            proceso.start();
        }
        for (Thread proceso:colThread) {
            try {
                proceso.join();
            } catch (InterruptedException ex) {
                System.out.println("ERROR JOIN");
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arreglo = new int[50000];
        int resultadoReal = llenarArreglo(arreglo);
        arregloSeis prueba = new arregloSeis(arreglo,6);
        Thread th1 = new Thread(prueba);
        th1.start();
        try {
            th1.join();
        }
        catch (Exception e) {
            System.out.println("ERROR");
        }
        System.out.println("Resultado esperado:" + resultadoReal + "Resultado dado:" + prueba.getResultado() );
    }
    
    //Lleno arreglo
    public static int llenarArreglo(int[] arreglo) {
        Random rand = new Random();
        int devuelto = 0;
        for (int i = 0; i < arreglo.length; i++) {
            int agregar = rand.nextInt(1, 11);
            arreglo[i] = agregar;
            devuelto += agregar;
        } 
        return devuelto;
    }
    
    public int getResultado() {
        return this.resultado[0];
    }
    
    private class sumador implements Runnable {
        int posicionInicial;
        final int[] arreglo;
        int [] resultado;
        int numeroThreads;
        public sumador(int[] arreglo, int posicionInicial, int[] resultado, int numeroThreads) {
            this.arreglo = arreglo;
            this.posicionInicial = posicionInicial;
            this.resultado = resultado;
            this.numeroThreads = numeroThreads;
            
        }
        
        @Override
        public void run() {
            int pos = posicionInicial;
            while (pos < arreglo.length) {
                synchronized (resultado) {
                    resultado[0] += arreglo[pos];
                    pos += numeroThreads;
                }
                
                
            }
        }
        
    }
}
