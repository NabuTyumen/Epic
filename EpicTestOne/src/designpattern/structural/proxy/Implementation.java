package designpattern.structural.proxy;

/**
 * Implémentation de l'interface.
 * Définit l'objet représenté par le "Proxy"
 */
public class Implementation implements Abstraction {
    
    public void display() {
        System.out.println("Méthode display() de la classe d'implementation");
    }
}
