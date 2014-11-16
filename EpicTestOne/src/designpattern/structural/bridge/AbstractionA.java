package designpattern.structural.bridge;


	/**
	 * Sous-classe concr�te de l'abstraction
	 */
	public class AbstractionA extends Abstraction {

	    public AbstractionA(Implementation pImplementation) {
	        super(pImplementation);
	    }
	    
	    public void operation() {
	        System.out.println("--> M�thode operation() de AbstractionA");
	        operationImpl1("A");
	        operationImpl2(1);
	        operationImpl1("B");
	    }
	}

