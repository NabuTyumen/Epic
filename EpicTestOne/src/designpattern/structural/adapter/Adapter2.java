package designpattern.structural.adapter;

/**
 * Fit the non standard implementation 
 * Second option : WITH COMPOSITION.
 */
public class Adapter2 implements Standard {

    private ImplAdapte adapte = new ImplAdapte();
    
    /**
     * Appelle les methods non standard
     * depuis une method respectant l'interface. 
     * 1°) Appel de la method réalisant la multiplication
     * 2°) Appel de la method d'Displayed du résultat
     * La classe adaptée compose l'adaptation, 
     * donc on appelle les methods de "ImplAdapte".
     */
    public void operation(int pNombre1, int pNombre2) {
        int lNombre = adapte.operationAdapte1(pNombre1, pNombre2);
        adapte.operationAdapte2(lNombre);
    }
}
