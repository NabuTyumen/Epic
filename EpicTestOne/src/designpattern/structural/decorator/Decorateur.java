package designpattern.structural.decorator;

/**
 * Define decorator interface.
 */
public abstract class Decorateur implements Abstraction {
    protected Abstraction abstraction;
    
    /**
     * The constructor of "Decorator" take in a object "Abstraction"
     * @param pAbstraction
     */
    public Decorateur(final Abstraction pAbstraction) {
        abstraction = pAbstraction;
    }
}
