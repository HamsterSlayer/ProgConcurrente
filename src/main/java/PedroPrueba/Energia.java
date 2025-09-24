package PedroPrueba;

public class Energia {
    private int energia;

    public Energia() {
        energia = 10;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public synchronized boolean cambiarEnergia(int cant) throws InterruptedException {
        boolean cambio = true;
        if (this.energia > 0) {
            if (cant > 0) {
                System.out.println("Energia aumentada en " + cant);
            } else {
                System.out.println("Energia disminuida en " + cant);
            }
            energia += cant;
            System.out.println("Energia restante: " + this.energia);
        } else {
            cambio = false;
        }
        return cambio;
    }

}
