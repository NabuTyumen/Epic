package designpattern.structural.bridge;


	/**
	 * Sub-class concrete of the abstraction
	 */
	public class AbstractionA extends Abstraction {

	    public AbstractionA(Implementation pImplementation) {
	        super(pImplementation);
	    }
	    
	    public void operation() {
	        System.out.println("--> Method operation() of AbstractionA");
	        operationImpl1("A");
	        operationImpl2(1);
	        operationImpl1("B");
	    }
	}

