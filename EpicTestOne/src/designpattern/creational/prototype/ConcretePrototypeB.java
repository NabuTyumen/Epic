package designpattern.creational.prototype;

/**
 * Sous-class de Prototype.
 */
public class ConcretePrototypeB extends Prototype {
    
    public ConcretePrototypeB(String pTexte) {
        super(pTexte);
    }
    
    /**
     * Méthode d'affichage.
     * Indique que c'est un objet de classe ConcretePrototypeA 
     * et la valeur de l'attribut texte. 
     */
    public void display() {
        System.out.println("ConcretePrototypeB with text : " + text);
    }
}
