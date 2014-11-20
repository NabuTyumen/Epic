package designpattern.creational.abstractfactory;

/**
 * Sub class of AbstractClasse
 * This class is instantiated by ConcreteFactoryA
 */
public class ClassA implements AbstractClass {
    
    /**
     * Implementation of method display
     */
    public void displayClass() {
        System.out.println(ClassA.class.toString());
    }
}