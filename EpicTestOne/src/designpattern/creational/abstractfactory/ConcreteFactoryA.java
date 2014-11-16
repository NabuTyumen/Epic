package designpattern.creational.abstractfactory;

/**
 * Impl�mente l'interface "AbstractFabrique".
 */
public class ConcreteFactoryA implements AbstractFactory {
    
    /**
     * La m�thode de Creation instancie un objet "ClasseA".
     * @return Un objet "ClasseA" qui vient d'�tre cr��.
     */
    public AbstractClass createClass() {
        return new ClassA();
    }
}
