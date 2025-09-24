/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author hamst
 */
public class ponedorLetra implements Runnable {
    char letra;
    controladorLetras controlador;
    ReentrantLock unLock; 
    
    public ponedorLetra(char letra, controladorLetras controlador) {
        this.letra = letra;
        this.controlador = controlador;
        unLock = this.controlador.getLock();
    }

    @Override
    public void run() {
        while(!controlador.terminado()){
            if (unLock.tryLock()) {
                if (controlador.esLaSiguienteLetra(letra)) {
                    controlador.ponerLetra(letra);
                    controlador.informar();
                }
            unLock.unlock();
            }
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
        controlador.informar();
    }
}
