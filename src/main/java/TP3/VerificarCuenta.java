/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

/**
 *
 * @author hamst
 */
    
    public class VerificarCuenta implements Runnable {
        private CuentaBanco cb = new CuentaBanco();
        
        @Override
        public void run() {
            for (int i = 0; i <= 3; i++) {
                try {
                    if (cb.getBalance() >= 10) {
                        this.HacerRetiro(10);
                    }
                    else {
                        System.out.println("La cuenta esta sobregirada.");
                    }
                } catch (InterruptedException ex) {
                }
            }
        }

        private synchronized void HacerRetiro(int cantidad) throws InterruptedException {
            if (cb.getBalance() >= cantidad) {
                System.out.println(Thread.currentThread().getName() +
            " esta realizando un retiro de: " + cantidad + ".");
            Thread.sleep(1000);
            cb.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName() +": Retiro realizado.");
            System.out.println(Thread.currentThread().getName() +": Los fondos son de: " + cb.getBalance());
            }
            else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr." + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de" + cb.getBalance());
            Thread.sleep(1000);
            }

    }
}
