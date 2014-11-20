package designpattern.structural.proxy;

/**
 * Intermédiaire entre la partie cliente et l'implémentation
 */
public class Proxy implements Abstraction {

    /**
     * Instancie l'object "Implementation", pour appeler
     * la vraie implémentation de la method.
     */
    public void display() {
        System.out.println("--> Method display() du Proxy : ");
        System.out.println("--> Création of the object Implementation au besoin");
        Implementation lImplementation = new Implementation();
        System.out.println("--> Appel de la method display() of the object Implementation");
        lImplementation.display();
    }
}