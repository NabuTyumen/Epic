package designpattern.structural.adapter;

/**
 * Adapte l'implémentation non standard avec l'héritage.
 */
public class Adaptateur extends ImplAdapte implements Standard {

    /**
     * Appelle les méthodes non standard 
     * depuis une méthode respectant l'interface. 
     * 1°) Appel de la méthode réalisant la multiplication
     * 2°) Appel de la méthode d'affichage du résultat
     * La classe adaptée est héritée, donc on appelle directement les méthodes
     */
    public void operation(int pNombre1, int pNombre2) {
        int lNombre = operationAdapte1(pNombre1, pNombre2);
        operationAdapte2(lNombre);
    }
}