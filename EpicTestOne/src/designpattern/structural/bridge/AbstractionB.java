package designpattern.structural.bridge;


/**
 * Sous-classe concrète de l'abstraction
 */
public class AbstractionB extends Abstraction {

    public AbstractionB(Implementation pImplementation) {
        super(pImplementation);
    }
    
    public void operation() {
        System.out.println("--> Méthode operation() de AbstractionB");
        operationImpl2(9);
        operationImpl2(8);
        operationImpl1("Z");
    }
}
