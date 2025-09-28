/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4_Semaforos.Filosofos;

/**
 *
 * @author hamst
 */
public class mesa implements Runnable{
    Filosofo[] filosofos;
    Tenedor[] tenedores;
    
   public mesa(int filosofos) {
       this.filosofos = new Filosofo[filosofos];
       tenedores = new Tenedor[filosofos];
       
       //Lleno los arrays
       for (int i = 0; i < this.tenedores.length; i++) {
           tenedores[i] = new Tenedor();
       }
       for (int i = 0; i < this.filosofos.length; i++) {
           this.filosofos[i] = new Filosofo(this,i);
       }
   }
   
   //Derecha siempre suma 
   public boolean agarrarDerecho(int posicion) {
       return tenedores[posicion].tomarTenedor();
   }
   
   //Izquierda siempre resta
   public boolean agarrarIzquierda(int posicion) {
       boolean resultado;
       if (posicion == 0) {
           resultado = tenedores[tenedores.length - 1].tomarTenedor();
       }
       else {
           resultado = tenedores[posicion - 1].tomarTenedor();
       }
       return resultado;
   }
   
   public void soltarTenedorIzquierdo(int posicion) {
       if (posicion == 0) {
           tenedores[tenedores.length - 1].liberarTenedor();
       }
       else {
           tenedores[posicion - 1].liberarTenedor();
       }
   }
   
   public void soltarTenedorDerecho(int posicion) {
       tenedores[posicion].liberarTenedor();
   }

   private boolean todosComieron() {
       boolean comieron = true;
       for (Filosofo filosofo: filosofos) {
           comieron &= filosofo.comio();
       }
       return comieron;
   }
    @Override
    public void run() {
        System.out.println("Iniciando cena...");
       for (Filosofo filo: filosofos) {
           Thread th = new Thread(filo);
           th.start();
       }
       while(!todosComieron()) {
           
       }
        System.out.println("LOS FILOSOFOS COMIERON");
    }
   
    public static void main(String[] args) {
        mesa Mesa = new mesa(5);
        Thread th = new Thread(Mesa);
        th.start();
    }
}
