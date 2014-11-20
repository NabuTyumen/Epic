package designpattern.structural.decorator;

/**
 * Implementation general interface.
 */
public class Implementation implements Abstraction {
    
    /**
     * Implementation of the method 
     * for the basis operation 
     */
    public void operation() {
        System.out.println("Implementation");
    }
}