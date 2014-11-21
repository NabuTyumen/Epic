package gof.creational.abstractfactory;

/**
 * Define interface of the method creation.
 */
public interface AbstractFactory {
    
    /**
     * Method creation of object from the class AbstractClasse.
     * @return created object.
     */
    public AbstractClass createClass();
}