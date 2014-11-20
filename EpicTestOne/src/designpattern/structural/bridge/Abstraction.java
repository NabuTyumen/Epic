package designpattern.structural.bridge;

/**
 * Define interface of the abstraction
 */
public abstract class Abstraction {

    // Reference to implementation
    private Implementation implementation;
    
    protected Abstraction(Implementation pImplementation) {
        implementation = pImplementation;
    }

    public abstract void operation(); 

    /**
     * Link to the method operationImpl1() of the implementation
     * @param pMessage
     */
    protected void operationImpl1(String pMessage) {
        implementation.operationImpl1(pMessage);
    }
    
    /**
     * Link to the method operationImpl2() of the implementation
     * @param pMessage
     */
    protected void operationImpl2(Integer pNombre) {
        implementation.operationImpl2(pNombre);
    }
}