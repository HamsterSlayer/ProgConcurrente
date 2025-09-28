package TP4_Semaforos.Filosofos;


public class Filosofo implements Runnable {
    boolean comio = false;
    mesa laMesa;
    int posicion;
    
    public Filosofo(mesa mesa, int pos) {
        laMesa = mesa;
        this.posicion = pos;
    }
    
    public boolean comio() {
        return comio;
    }
    
    @Override
    public void run() {
        boolean tenedorIzquierdo;
        boolean tenedorDerecho;
        while (!comio) {
        //Cada filosofo solo tomara los tenedores si estan libres
        tenedorDerecho = laMesa.agarrarDerecho(posicion);
        tenedorIzquierdo = laMesa.agarrarIzquierda(posicion);
        if (tenedorDerecho && tenedorIzquierdo) {
            System.out.println("El filosofo en la pos: " + posicion + "esta comiendo");
            try {
                Thread.sleep(200);
                comio = true;
            }
            catch(InterruptedException e) {
                System.out.println("ERROR");
            }
        }
        //Suelto los tenedores en caso de que haya agarrado alguno
        if (tenedorDerecho) {
        laMesa.soltarTenedorDerecho(posicion);
        tenedorDerecho = false;
        }
        if (tenedorIzquierdo) {
        laMesa.soltarTenedorIzquierdo(posicion);
        tenedorIzquierdo = false;
        }
        
        if (!comio) {
            System.out.println("Soy el filosofo en la pos: " + posicion + "y aun no comi asi que dejare los tenedores");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("ERROR");
            } 
        }

        }
    }
    
    
    
    
}
