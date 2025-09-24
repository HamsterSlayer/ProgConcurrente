package TP3;

import java.util.concurrent.locks.ReentrantLock;


public class controladorLetras {
    String texto;
    String resultadoTexto;
    int contador;
    ReentrantLock lockObjeto;
    
    public controladorLetras(String texto) {
        this.texto = texto;
        this.resultadoTexto = "";
        this.contador = 0;
        lockObjeto = new ReentrantLock();
    }
    
    public ReentrantLock getLock() {
        return lockObjeto;
    }
    
    public boolean esLaSiguienteLetra(char letra) {
        return texto.charAt(contador) == letra;
    }
    
    public void ponerLetra(char letra) {
        System.out.println("AFUERA");
        if (contador < texto.length()) {
            System.out.println("ADENTRO");
        resultadoTexto += letra;
        contador++;
        }
    }
    
    public boolean terminado() {
        return texto.equals(resultadoTexto);
    }
    
    public void informar() {
        System.out.println("resultado:" + resultadoTexto);
    }
    
    
    public static void main(String[] args) {
        controladorLetras manager = new controladorLetras("ABCC");
        Thread th1 = new Thread(new ponedorLetra('A',manager));
        Thread th2 = new Thread(new ponedorLetra('B',manager));
        Thread th3 = new Thread(new ponedorLetra('C',manager));
        th1.start();
        th2.start();
        th3.start();
    }
}
