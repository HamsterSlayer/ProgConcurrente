
package TP3;

public class caracteresOrdenados implements Runnable {
    String[] stringCompartido;
    char letra;
    String resultadoEsperado;
    int[] cursor;
    
    public caracteresOrdenados(String[] stringCompartido, char letra, String resultadoEsperado, int[] cursor) {
        this.stringCompartido = stringCompartido;
        this.letra = letra;
        this.resultadoEsperado = resultadoEsperado;
        this.cursor = cursor;
    }
    
    @Override
    public void run() {
        int repeticiones = repeticiones();
        System.out.println(repeticiones);
        
        while (repeticiones > 0 && !stringCompartido[0].equals(resultadoEsperado)) {
            
                if (stringCompartido[0].length() == 0) {
                    //Caso cero
                    System.out.println("ESTA VACIO");
                    if (resultadoEsperado.charAt(0) == letra) {
                        ponerLetra(letra);
                        repeticiones--;
                    }
                } else if (resultadoEsperado.charAt(cursor[0]) == letra) {
                    repeticiones--;
                    ponerLetra(letra);
                    System.out.println("PONGO LETRA: " + letra);
                }

        }
        
    }
    
    public void ponerLetra(char letra) {
        synchronized (stringCompartido) {
            stringCompartido[0] += letra;
            cursor[0] += 1;
        }
    }
    private int repeticiones() {
        int repeticiones = 0;
        for (int i = 0; i < resultadoEsperado.length(); i++) {
            if (resultadoEsperado.charAt(i) == letra) {
                repeticiones++;
            }
        }
        return repeticiones;
    }
    
    public static void main(String[] args) {
        String texto = "ABBCCC";
        String[] resultado = {""};
        int[] cursor = {0};
        caracteresOrdenados letraA = new caracteresOrdenados(resultado,'A',texto, cursor);
        caracteresOrdenados letraB = new caracteresOrdenados(resultado,'B',texto, cursor);
        caracteresOrdenados letraC = new caracteresOrdenados(resultado,'C',texto, cursor);
        
        Thread th1 = new Thread(letraA);
        Thread th2 = new Thread(letraB);
        Thread th3 = new Thread(letraC);
        
        th1.start();
        th2.start();
        th3.start();
        
        try {
            th1.join();
            th2.join();
            th3.join();
        }
        catch (InterruptedException e) {
            System.out.println("ERROR");
        }
        
        System.out.println("ESPERADO: " + texto + " RESULTADO: " + resultado[0]);
    }
}
