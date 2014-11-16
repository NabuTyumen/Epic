package designpattern.structural.decorator;

/**
 * Implémente un décorateur
 */
public class ImplDecorateurB extends Decorateur {
    
    public ImplDecorateurB(final Abstraction pAbstraction) {
        super(pAbstraction);
    }

    /**
     * Implémentation de la méthode
     * pour la décoration de "ImplDecorateurB".
     */
    public void operation() {
        System.out.println("ImplDecorateurB avant");
        abstraction.operation();
        System.out.println("ImplDecorateurB apres");
    }
}
