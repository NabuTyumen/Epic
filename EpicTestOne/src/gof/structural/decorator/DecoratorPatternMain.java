package gof.structural.decorator;

public class DecoratorPatternMain {

    public static void main(String[] args) {
        // Creation of implementation and decorators
        final Implementation lImpl = new Implementation();
        final ImplDecoratorB lImplDecB = new ImplDecoratorB(lImpl);
        final ImplDecoratorA lImplDecA = new ImplDecoratorA(lImplDecB);
        
        // Call method of decorateur 
        lImplDecA.operation();

        // Displayed :
        // ImplDecorateurA avant
        // ImplDecorateurB avant
        // Implementation
        // ImplDecorateurB apres
        // ImplDecorateurA apres
    }
}