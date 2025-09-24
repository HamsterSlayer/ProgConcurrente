package PedroPrueba;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Modificador implements Runnable {
    private int cant;
    private Energia energia;

    public Modificador(int cant, Energia energia) {
        this.cant = cant;
        this.energia = energia;
    }

    public int getcant() {
        return cant;
    }

    public void setcant(int cant) {
        this.cant = cant;
    }

    public boolean modificarEnergia() throws InterruptedException {
        return energia.cambiarEnergia(cant);
    }

    @Override
    public void run() {
        while (this.energia.getEnergia() > 0) {
            try {
                boolean sigue = true;
                while (sigue) {
                    sigue = modificarEnergia();
                                Thread.sleep(1000);
                    if (!sigue) {
                        System.out.println("No se puede más modificar");
                    }
                }
            } catch (InterruptedException e) {
                Logger.getLogger(Modificador.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }
}
