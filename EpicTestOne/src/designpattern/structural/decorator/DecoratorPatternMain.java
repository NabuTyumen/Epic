package designpattern.structural.decorator;

public class DecoratorPatternMain {

    public static void main(String[] args) {
        // Creation de l'implementation et des décorateurs
        final Implementation lImpl = new Implementation();
        final ImplDecorateurB lImplDecB = new ImplDecorateurB(lImpl);
        final ImplDecorateurA lImplDecA = new ImplDecorateurA(lImplDecB);
        
        // Appel de la méthode du décorateur "conteneur"
        lImplDecA.operation();

        // Affichage :
        // ImplDecorateurA avant
        // ImplDecorateurB avant
        // Implementation
        // ImplDecorateurB apres
        // ImplDecorateurA apres
    }
}