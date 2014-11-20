package designpattern.creational.factory;

/**
 * Substitute the method "createClass".
 * Instanciate a object "ClassB".
 */
public class FactoryB extends Factory {

    /**
     * Method de Creation
     * @return  always return a object ClassB.
     */
    public AbstractClasse createClass(boolean pIsClasseA) {
        return new ClassB();
    }
}
