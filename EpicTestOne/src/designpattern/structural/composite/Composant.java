package designpattern.structural.composite;

/**
 * Définit l'interface d'un objet pouvant être un composant 
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
     * Opération commune à tous les "Composant"
     */
    public abstract void operation();
}