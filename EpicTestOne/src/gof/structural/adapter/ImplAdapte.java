package gof.structural.adapter;

/**
* Provides the functionality defined in the interface "Standard", but do not meet the interface.
 */
public class ImplAdapte {

    public int operationAdapte1(int pNombre1, int pNombre2) {
        return pNombre1 * pNombre2;
    }
    
    /**
     * Provides the functionality defined in the interface
     * but the method do not have the good name
     * and do not take the same parameter.
     */
    public void operationAdapte2(int pNombre) {
        System.out.println("Adapte : Number is : " + pNombre);
    }
}