package designpattern.structural.decorator;

/**
 * Définit l'interface du décorateur.
 */
public abstract class Decorateur implements Abstraction {
    protected Abstraction abstraction;
    
    /**
     * Le constructeur du "Decorateur" reçoit un objet "Abstraction"
     * @param pAbstraction
     */
    public Decorateur(final Abstraction pAbstraction) {
        abstraction = pAbstraction;
    }
}
