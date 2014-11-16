package designpattern.structural.adapter;

/**
 * Adapte l'implémentation non standard avec la composition.
 */
public class Adapteur implements Standard {

    private ImplAdapte adapte = new ImplAdapte();
    
    /**
     * Appelle les méthodes non standard
     * depuis une méthode respectant l'interface. 
     * 1°) Appel de la méthode réalisant la multiplication
     * 2°) Appel de la méthode d'affichage du résultat
     * La classe adaptée compose l'adaptation, 
     * donc on appelle les méthodes de "ImplAdapte".
     */
    public void operation(int pNombre1, int pNombre2) {
        int lNombre = adapte.operationAdapte1(pNombre1, pNombre2);
        adapte.operationAdapte2(lNombre);
    }
}
