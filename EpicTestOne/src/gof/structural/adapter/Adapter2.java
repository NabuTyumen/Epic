package gof.structural.adapter;

/**
 * Fit the non standard implementation 
 * Second option : WITH COMPOSITION.
 */
public class Adapter2 implements Standard {

    private ImplAdapte adapte = new ImplAdapte();
    
    /**
     * Call the non standard methods 
     * from a method that match interface. 
     * 1°) Call a method processing the multiplication
     * 2°) Call method displaying the result
     * The class adapt compose adaptation, 
     * then we call the methods of "ImplAdapte".
     */
    public void operation(int pNombre1, int pNombre2) {
        int lNombre = adapte.operationAdapte1(pNombre1, pNombre2);
        adapte.operationAdapte2(lNombre);
    }
}
