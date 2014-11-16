package designpattern.creational.abstractfactory;

/**
 * Implémente l'interface "AbstractFabrique".
 */
public class ConcreteFactoryA implements AbstractFactory {
    
    /**
     * La méthode de Creation instancie un objet "ClasseA".
     * @return Un objet "ClasseA" qui vient d'être créé.
     */
    public AbstractClass createClass() {
        return new ClassA();
    }
}
