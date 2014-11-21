package gof.structural.decorator;

/**
 * Implement un d�corateur
 */
public class ImplDecoratorA extends Decorateur {
    
    public ImplDecoratorA(final Abstraction pAbstraction) {
        super(pAbstraction);
    }

    /**
     * Implementation de la method
     * pour la d�coration de "ImplDecorateurA".
     * Des op�rations sont donees avant et apr�s 
     * l'appel � la method of the object "Abstraction"
     * pass� au Constructor.
     * La method ignore si cet object est un autre d�corateur
     * ou l'impl�mentation
     */
    public void operation() {
        System.out.println("ImplDecorateurA avant");
        abstraction.operation();
        System.out.println("ImplDecorateurA apres");
    }
}