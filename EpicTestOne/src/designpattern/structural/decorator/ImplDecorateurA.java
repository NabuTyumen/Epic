package designpattern.structural.decorator;

/**
 * Implémente un décorateur
 */
public class ImplDecorateurA extends Decorateur {
    
    public ImplDecorateurA(final Abstraction pAbstraction) {
        super(pAbstraction);
    }

    /**
     * Implémentation de la méthode
     * pour la décoration de "ImplDecorateurA".
     * Des opérations sont effectuées avant et après 
     * l'appel à la méthode de l'objet "Abstraction"
     * passé au constructeur.
     * La méthode ignore si cet objet est un autre décorateur
     * ou l'implémentation
     */
    public void operation() {
        System.out.println("ImplDecorateurA avant");
        abstraction.operation();
        System.out.println("ImplDecorateurA apres");
    }
}