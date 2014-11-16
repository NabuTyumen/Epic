package designpattern.creational.abstractfactory;

/**
 * Implémente l'interface "AbstractFabrique".
 */
public class ConcreteFactoryB implements AbstractFactory {
    
    /**
     * La méthode de Creation instancie un objet "ClasseB".
     * @return Un objet "ClasseB" qui vient d'être créé.
     */
    public AbstractClass createClass() {
        return new ClassB();
    }
}	
