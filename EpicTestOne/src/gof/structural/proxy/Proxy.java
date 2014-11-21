package gof.structural.proxy;

/**
 * Intermediate between the client and the Implementation
 */
public class Proxy implements Abstraction {

    /**
     * Instantiate the object "Implementation", to call
     * the real implementation of the method.
     */
    public void display() {
        System.out.println("--> Method display() of Proxy : ");
        System.out.println("--> Creation of the object Implementation when needed");
        Implementation lImplementation = new Implementation();
        System.out.println("--> Call of the method display() of the object Implementation");
        lImplementation.display();
    }
}