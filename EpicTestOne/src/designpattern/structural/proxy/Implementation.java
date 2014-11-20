package designpattern.structural.proxy;

/**
 * Implementation of the interface.
 * Define l'object repr�sent� par le "Proxy"
 */
public class Implementation implements Abstraction {
    
    public void display() {
        System.out.println("Method display() de la classe d'implementation");
    }
}
