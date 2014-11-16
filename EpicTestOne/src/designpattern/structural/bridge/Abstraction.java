package designpattern.structural.bridge;

/**
 * D�finit l'interface de l'abstraction
 */
public abstract class Abstraction {

    // R�f�rence vers l'impl�mentation
    private Implementation implementation;
    
    protected Abstraction(Implementation pImplementation) {
        implementation = pImplementation;
    }

    public abstract void operation(); 

    /**
     * Lien vers la m�thode operationImpl1() de l'impl�mentation
     * @param pMessage
     */
    protected void operationImpl1(String pMessage) {
        implementation.operationImpl1(pMessage);
    }
    
    /**
     * Lien vers la m�thode operationImpl2() de l'impl�mentation
     * @param pMessage
     */
    protected void operationImpl2(Integer pNombre) {
        implementation.operationImpl2(pNombre);
    }
}