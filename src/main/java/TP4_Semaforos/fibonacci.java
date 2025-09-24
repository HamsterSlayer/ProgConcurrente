package TP4_Semaforos;
import java.util.Scanner;
        
public class fibonacci {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        
    }

    public static String pedirNombre(Scanner sc) {
    String nombre = "";
    boolean valido = false;

    while (!valido) {
        System.out.print("Ingrese el primer nombre del paciente: ");
        nombre = sc.next();    // agarra solo la primera palabra
        sc.nextLine();         // limpia el resto de la línea (por si puso más cosas)

        if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
            valido = true;
        } else {
            System.out.println("El nombre solo puede contener letras y sin espacios. Intente de nuevo.");
        }
    }
    return nombre;
    }
}
