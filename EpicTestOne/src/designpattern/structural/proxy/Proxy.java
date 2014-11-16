package designpattern.structural.proxy;

/**
 * Interm�diaire entre la partie cliente et l'impl�mentation
 */
public class Proxy implements Abstraction {

    /**
     * Instancie l'objet "Implementation", pour appeler
     * la vraie impl�mentation de la m�thode.
     */
    public void display() {
        System.out.println("--> M�thode display() du Proxy : ");
        System.out.println("--> Cr�ation de l'objet Implementation au besoin");
        Implementation lImplementation = new Implementation();
        System.out.println("--> Appel de la m�thode display() de l'objet Implementation");
        lImplementation.display();
    }
}