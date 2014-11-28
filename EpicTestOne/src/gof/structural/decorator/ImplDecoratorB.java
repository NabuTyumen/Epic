package gof.structural.decorator;

/**
 * Implement un d�corateur
 */
public class ImplDecoratorB extends Decorator {
    
    public ImplDecoratorB(final Abstraction pAbstraction) {
        super(pAbstraction);
    }

    /**
     * Implementation de la method
     * pour la d�coration de "ImplDecorateurB".
     */
    public void operation() {
        System.out.println("ImplDecorateurB avant");
        abstraction.operation();
        System.out.println("ImplDecorateurB apres");
    }
}
