/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpThreads;

/**
 *
 * @author hamst
 */
public class Cliente extends Thread {
    
    /*
    A- Solamente ocurren dos hilos: juan e ines.
    B- EL metodo uso consigue el thread siendo trabajado actualmente. 
    C- /
    d- Si agrego la linea, mostrará el thread del main.
    e- Si cambio el orden no debería suceder nada, pues iniciaran a diferente tiempo pero no cambiará la aleatoridad del resultado.
    */
    public static void main (String[] args){
Cliente juan=new Cliente();
juan.setName("Juan Lopez");
Cliente ines=new Cliente ();
ines.setName ("Ines Garcia");
juan.start();
ines.start();
Recurso.uso();
}
    
    public void run() {
        System.out.println("Soy" + Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e) {
            
        };
    }
    
    
    
    
}

 class Recurso {
static void uso(){
Thread t=Thread.currentThread();
System.out.println("en Recurso: Soy" + t.getName());
}
}

