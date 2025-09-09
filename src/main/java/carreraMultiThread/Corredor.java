
package carreraMultiThread;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Corredor implements Runnable {

    String nombre;
    int distanciaRecorrida;
    int distanciaARecorrer;
    Random numberGenerator;
    List<String> ranking; 
    
    public Corredor(String nombre, int distanciaARecorrer, List<String> ranking) {
        this.nombre = nombre;
        this.distanciaARecorrer = distanciaARecorrer;
        distanciaRecorrida = 0;
        numberGenerator = new Random();
        this.ranking = ranking;
        long duracion;
    }
    
    @Override
    public void run() {
        Instant start = Instant.now();
        while (distanciaRecorrida < distanciaARecorrer) {
        System.out.println("Nombre: " + nombre + " distancia: " + distanciaRecorrida + "//" + distanciaARecorrer);
        distanciaRecorrida += numberGenerator.nextInt(1,11);
        try {
            Thread.sleep(100);
        }
        catch(InterruptedException e) {
            
        }
        }
        //De forma sincronizada agrego al ranking
        Instant finish = Instant.now();
        synchronized(ranking) {
            ranking.add(nombre +   " en: "+ Duration.between(start,finish).toMillis() + "ms");
        }
        System.out.println(nombre.toUpperCase() + " TERMINO LA CARRERA");
        
        
    }
    
    public static void main(String [] args) {
        List<String> clasificacion = new ArrayList<>();
        int distancia = 100;
        Corredor pedro = new Corredor("pedro - Maruzensky", distancia,clasificacion);
        Corredor agustin = new Corredor("agustin - Air Groove", distancia,clasificacion);
        Corredor ivo = new Corredor("ivo - Haru", distancia,clasificacion);
        Corredor[] corredores = {pedro,ivo,agustin};
        Thread th = new Thread(pedro);
        Thread th2 = new Thread(agustin);
        Thread th3 = new Thread(ivo);
        Thread[] ths = {th,th2,th3};
        
        for (Thread thUnidad: ths) {
            thUnidad.start();
        }
        for (Thread thUnidad: ths) {
            try {
                thUnidad.join();
            }
            catch(InterruptedException e) {
                
            }
        }
        
        System.out.println("RANKING-------------------------");
        for(int i = 0 ; i < clasificacion.size(); i++) {
            System.out.println(i+1 + ". " + clasificacion.get(i));
            
        }
        
        
    }
}
