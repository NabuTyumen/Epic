package designpattern.creational.prototype;

/**
 * Sous-class de Prototype.
 */
public class ConcretePrototypeA extends Prototype {
    
    public ConcretePrototypeA(String pTexte) {
        super(pTexte);
    }

    /**
     * Méthode d'affichage.
     * Indique que c'est un objet de classe ConcretePrototypeA 
     * et la value de l'attribut texte. 
     */
    public void display() {
        System.out.println("ConcretePrototypeA avec texte : " + text);
    }
}
