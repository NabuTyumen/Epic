package gof.creational.factory;

/**
 * Substitue la method "creerClasse".
 * Instancie a object "ClassA".
 */
public class FactoryA extends Factory {

    /**
     * Creation method 
     * The method return a object ClassA if parameter is true.
     * Otherwise, return a object ClassB.
     * @return a object ClassA or ClassB.
     */
    public AbstractClasse createClass(boolean pIsClasseA) {
        if(pIsClasseA) {
            return new ClassA();
        }
        else {
            return new ClassB();
        }
    }
}
