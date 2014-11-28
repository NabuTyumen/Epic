package gof.structural.decorator;

/**
 * Define decorator interface.
 */
public abstract class Decorator implements Abstraction {
    protected Abstraction abstraction;
    
    /**
     * The constructor of "Decorator" take in a object "Abstraction"
     * @param pAbstraction
     */
    public Decorator(final Abstraction pAbstraction) {
        abstraction = pAbstraction;
    }
}
