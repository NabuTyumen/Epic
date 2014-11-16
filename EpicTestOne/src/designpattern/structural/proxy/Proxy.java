package designpattern.structural.proxy;

/**
 * Intermédiaire entre la partie cliente et l'implémentation
 */
public class Proxy implements Abstraction {

    /**
     * Instancie l'objet "Implementation", pour appeler
     * la vraie implémentation de la méthode.
     */
    public void display() {
        System.out.println("--> Méthode display() du Proxy : ");
        System.out.println("--> Création de l'objet Implementation au besoin");
        Implementation lImplementation = new Implementation();
        System.out.println("--> Appel de la méthode display() de l'objet Implementation");
        lImplementation.display();
    }
}