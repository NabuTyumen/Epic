package designpattern.creational.abstractfactory;

/**
 * Impl�mente l'interface "AbstractFabrique".
 */
public class ConcreteFactoryB implements AbstractFactory {
    
    /**
     * La m�thode de cr�ation instancie un objet "ClasseB".
     * @return Un objet "ClasseB" qui vient d'�tre cr��.
     */
    public AbstractClass createClass() {
        return new ClassB();
    }
}	
