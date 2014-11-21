package gof.creational.abstractfactory;

/**
 * Sub class of AbstractClasse
 * This class is instantiated by ConcreteFactoryB
 */
public class ClassB implements AbstractClass {
    
    /**
     * Implementation of method display
     */
    public void displayClass() {
        System.out.println(ClassB.class.toString());
    }
}
