package designpattern.structural.proxy;

/**
 * Impl�mentation de l'interface.
 * D�finit l'objet repr�sent� par le "Proxy"
 */
public class Implementation implements Abstraction {
    
    public void display() {
        System.out.println("M�thode display() de la classe d'implementation");
    }
}
