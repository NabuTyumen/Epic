package designpattern.creational.abstractfactory;

/**
 * Implement interface "AbstractFactory".
 */
public class ConcreteFactoryB implements AbstractFactory {
    
    /**
     * The method create instantiate a object "ClassB".
     * @return the object created.
     */
    public AbstractClass createClass() {
        return new ClassB();
    }
}	
