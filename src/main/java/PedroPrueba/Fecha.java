/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PedroPrueba;

/**
 *
 * @author hamst
 */
public class Fecha {
    int dia;
    int mes;
    int año;
    int[] diasPorMes = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] diasPorMesBisiesto = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    @Override
    public String toString() {
        return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", a\u00f1o=" + año + '}';
    }
    
    public boolean esBisiesto(int añoEntrante) {
        return (añoEntrante % 4 == 0 && añoEntrante % 100 != 0) || (añoEntrante %400 == 0);
    }
    
    public void agregarDias(int diasSumados) {
        int diasRestantes = diasRestantes();
        //Verifico si puede pasar de mes
        if (diasSumados >= diasRestantes) {
            diasSumados -= diasRestantes;
            avanzarMes();
            
            //Voy pasando meses
            while(diasSumados >= diasRestantes()) {
                diasSumados -= diasRestantes();
                avanzarMes();
            }
        }
            this.dia+= diasSumados;
        
    }
    
    private int diasDelAño(int año) {
        int devuelto;
        if (esBisiesto(año)) {
            devuelto = 366;
        }
        else {
            devuelto = 365;
        }
        return devuelto;
    }
    
    private void avanzarMes() {
        this.dia = 1;
        this.mes++;
        if (this.mes > 12) {
            this.mes = 1;
            this.año++;
        }
    }
    private int diasRestantes() {
        int devuelto;
        if (esBisiesto(año)) {
            devuelto = diasPorMesBisiesto[mes-1] - dia;
        }
        else {
            devuelto = diasPorMesBisiesto[mes-1] - dia; 
        }
        return devuelto;
    }
    
    public static void main(String[] args) {
        Fecha fecha = new Fecha(27,3,1990);
        System.out.println(fecha.toString());
        fecha.agregarDias(400);
        System.out.println(fecha.toString());
        //11/9/2001
        //dias agregados: 
    }
}
