package gof.structural.decorator;

/**
 * Implement un décorateur
 */
public class ImplDecoratorA extends Decorateur {
    
    public ImplDecoratorA(final Abstraction pAbstraction) {
        super(pAbstraction);
    }

    /**
     * Implementation de la method
     * pour la décoration de "ImplDecorateurA".
     * Des opérations sont donees avant et après 
     * l'appel à la method of the object "Abstraction"
     * passé au Constructor.
     * La method ignore si cet object est un autre décorateur
     * ou l'implémentation
     */
    public void operation() {
        System.out.println("ImplDecorateurA avant");
        abstraction.operation();
        System.out.println("ImplDecorateurA apres");
    }
}