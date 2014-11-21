package gof.structural.bridge;


/**
 * Sub-class concrete of abstraction
 */
public class AbstractionB extends Abstraction {

    public AbstractionB(Implementation pImplementation) {
        super(pImplementation);
    }
    
    public void operation() {
        System.out.println("--> Method operation() of AbstractionB");
        operationImpl2(9);
        operationImpl2(8);
        operationImpl1("Z");
    }
}
