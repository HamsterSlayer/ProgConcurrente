/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

/**
 *
 * @author hamst
 */
public class CriaturaOscura implements Runnable {
   int energia;
   int poder;
   Heroe protagonista;
   
   public CriaturaOscura(int energia, int poder, Heroe prota) {
       this.energia = energia;
       this.poder = poder;
       this.protagonista = prota;
   }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            protagonista.restarEnergia(poder);
        }
    }
   
   
}
