package designpattern.creational.prototype;

/**
 * Définit l'interface de l'objet à dupliquer.
 */
public abstract class Prototype implements Cloneable {

    protected String text;
    
    /**
     * Constructeur de la classe.
     * @param pTexte
     */
    public Prototype(String pTexte) {
        text = pTexte;
    }
    
    /**
     * La méthode clone est protected dans Object.
     * On doit la substituer pour la rendre visible.
     * De plus, il faut que la classe implémente l'interface Cloneable. 
     * Depuis Java5, on peut retourner un sous-type de Object.
     */
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
    
    public void setTexte(String pTexte) {
        text = pTexte;
    }
    
    /**
     * Méthode d'affichage des informations de l'objet.
     */
    public abstract void display();
}
