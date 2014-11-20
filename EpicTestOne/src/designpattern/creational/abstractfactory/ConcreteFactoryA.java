package designpattern.creational.abstractfactory;

/**
 * Implement interface "AbstractFactory".
 */
public class ConcreteFactoryA implements AbstractFactory {
    
    /**
     * The method create instantiate a object "ClassA".
     * @return the object created.
     */
    public AbstractClass createClass() {
        return new ClassA();
    }
}
