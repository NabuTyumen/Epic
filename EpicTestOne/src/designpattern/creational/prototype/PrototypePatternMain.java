package designpattern.creational.prototype;

public class PrototypePatternMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        // Instancie un objet de classe ConcretePrototypeA
        // et un autre de classe ConcretePrototypeB
        // de "manière traditionnelle".
        Prototype lPrototypeA = new ConcretePrototypeA("Original");
        Prototype lPrototypeB = new ConcretePrototypeB("Original");
        
        // Duplique les objets précédemment créés/
        Prototype lPrototypeAClone = lPrototypeA.clone();
        Prototype lPrototypeBClone = lPrototypeB.clone();
        
        // Affiche les objets : 
        // les clones sont identiques aux originaux
        lPrototypeA.display();
        lPrototypeAClone.display();
        lPrototypeB.display();
        lPrototypeBClone.display();
        
        // Modifie les clones
        lPrototypeAClone.setTexte("Clone (enfait)");
        lPrototypeBClone.setTexte("Clone (enfait)");
        
        // Met en évidence que les clones
        // sont bien des instances à part.
        lPrototypeA.display();
        lPrototypeAClone.display();
        lPrototypeB.display();
        lPrototypeBClone.display();
        
        // Affichage :
        // ConcretePrototypeA avec texte : Original
        // ConcretePrototypeA avec texte : Original
        // ConcretePrototypeB avec texte : Original
        // ConcretePrototypeB avec texte : Original
        // ConcretePrototypeA avec texte : Original
        // ConcretePrototypeA avec texte : Clone (enfait)
        // ConcretePrototypeB avec texte : Original
        // ConcretePrototypeB avec texte : Clone (enfait)
    }
}