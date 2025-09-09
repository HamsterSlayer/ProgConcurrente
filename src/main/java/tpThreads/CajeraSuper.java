/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpThreads;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author hamst
 */
public class CajeraSuper implements Runnable {
    private String nombre;
    private ClienteSuper cliente;
    
    public CajeraSuper (String nombre, ClienteSuper unCliente) {
        this.nombre = nombre;
        this.cliente = unCliente;
    }
    
    public void procesarCompra(ClienteSuper unCliente) {
        Instant inicio = Instant.now();
        System.out.printf("El cajero %s esta procesando la compra de %s.\n",this.nombre,unCliente.getNombre());
        int[] productos = unCliente.getProductos();
        for (int producto : productos) {
            System.out.println(". " + unCliente.getNombre());
            esperarSegundos(producto);
        }Instant fin = Instant.now();
        System.out.println("Ok");
        System.out.printf("El cajero %s termino de procesar la compra de %s.\n TIEMPO TOTAL: %ds \n",this.nombre,unCliente.getNombre(), Duration.between(inicio, fin).toSeconds());
    }
    
    private void esperarSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        }
        catch (InterruptedException e) {
            System.out.println("INTERRUPTED EXCEPTION");
        }
    }
    
    public static void main(String[] args) {
        ClienteSuper marcos = new ClienteSuper("Marcos",new int[] {10,5,5});
        ClienteSuper nico = new ClienteSuper("Nico", new int[] {10,5,5});
        CajeraSuper agustin = new CajeraSuper("Agustin",marcos);
        CajeraSuper juan = new CajeraSuper("Juan",nico);
        
        Thread t1 = new Thread(agustin);
        Thread t2 = new Thread(juan);
        
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        procesarCompra(this.cliente);
    }
}
