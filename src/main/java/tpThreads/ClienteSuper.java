
package tpThreads;

/**
 *
 * @author hamst
 */
public class ClienteSuper {
    private String nombre;
    private int[] productos;
    
    public ClienteSuper(String nombre, int[] productos) {
        this.nombre = nombre;
        this.productos = productos;
    }
    
    public int[] getProductos() {
        return productos;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    
}
