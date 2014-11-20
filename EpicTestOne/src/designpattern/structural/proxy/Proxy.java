package designpattern.structural.proxy;

/**
 * Interm�diaire entre la partie cliente et l'impl�mentation
 */
public class Proxy implements Abstraction {

    /**
     * Instancie l'object "Implementation", pour appeler
     * la vraie impl�mentation de la method.
     */
    public void display() {
        System.out.println("--> Method display() du Proxy : ");
        System.out.println("--> Cr�ation of the object Implementation au besoin");
        Implementation lImplementation = new Implementation();
        System.out.println("--> Appel de la method display() of the object Implementation");
        lImplementation.display();
    }
}