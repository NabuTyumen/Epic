package designpattern.structural.bridge;

/**
 * Sub-class concrete of implementation
 */
public class ImplementationB implements Implementation {

    public void operationImpl1(String pMessage) {
        System.out.println("operationImpl1 of ImplementationB : " + pMessage);
    }
    
    public void operationImpl2(Integer pNombre) {
        System.out.println("operationImpl2 of ImplementationB : " + pNombre);
    }
}
