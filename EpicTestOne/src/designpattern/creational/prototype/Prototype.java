package designpattern.creational.prototype;

/**
 * D�finit l'interface de l'objet � dupliquer.
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
     * La m�thode clone est protected dans Object.
     * On doit la substituer pour la rendre visible.
     * De plus, il faut que la classe impl�mente l'interface Cloneable. 
     * Depuis Java5, on peut retourner un sous-type de Object.
     */
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
    
    public void setTexte(String pTexte) {
        text = pTexte;
    }
    
    /**
     * M�thode d'affichage des informations de l'objet.
     */
    public abstract void display();
}
