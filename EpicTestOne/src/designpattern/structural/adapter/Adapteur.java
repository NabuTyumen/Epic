package designpattern.structural.adapter;

/**
 * Adapte l'impl�mentation non standard avec la composition.
 */
public class Adapteur implements Standard {

    private ImplAdapte adapte = new ImplAdapte();
    
    /**
     * Appelle les m�thodes non standard
     * depuis une m�thode respectant l'interface. 
     * 1�) Appel de la m�thode r�alisant la multiplication
     * 2�) Appel de la m�thode d'affichage du r�sultat
     * La classe adapt�e compose l'adaptation, 
     * donc on appelle les m�thodes de "ImplAdapte".
     */
    public void operation(int pNombre1, int pNombre2) {
        int lNombre = adapte.operationAdapte1(pNombre1, pNombre2);
        adapte.operationAdapte2(lNombre);
    }
}
