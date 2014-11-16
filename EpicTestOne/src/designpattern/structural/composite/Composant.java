package designpattern.structural.composite;

/**
 * D�finit l'interface d'un objet pouvant �tre un composant 
 * d'un autre objet de l'arborescence.
 */
public abstract class Composant {

    // Nom de "Composant"
    protected String nom;
    
    /**
     * Constructeur
     * @param pNom Nom du "Composant"
     */
    public Composant(final String pNom) {
        nom = pNom;
    }
    
    /**
     * Op�ration commune � tous les "Composant"
     */
    public abstract void operation();
}