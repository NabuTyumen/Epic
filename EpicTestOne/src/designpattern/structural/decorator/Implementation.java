package designpattern.structural.decorator;

/**
 * Implémente l'interface générale.
 */
public class Implementation implements Abstraction {
    
    /**
     * Implémentation de la méthode 
     * pour l'opération de base 
     */
    public void operation() {
        System.out.println("Implementation");
    }
}