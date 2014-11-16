package designpattern.structural.adapter;

/**
 * Adapte l'impl�mentation non standard avec l'h�ritage.
 */
public class Adaptateur extends ImplAdapte implements Standard {

    /**
     * Appelle les m�thodes non standard 
     * depuis une m�thode respectant l'interface. 
     * 1�) Appel de la m�thode r�alisant la multiplication
     * 2�) Appel de la m�thode d'affichage du r�sultat
     * La classe adapt�e est h�rit�e, donc on appelle directement les m�thodes
     */
    public void operation(int pNombre1, int pNombre2) {
        int lNombre = operationAdapte1(pNombre1, pNombre2);
        operationAdapte2(lNombre);
    }
}