package designpattern.structural.bridge;

/**
 * Sub-class concrete of implementation
 */
public class ImplementationA implements Implementation {

    public void operationImpl1(String pMessage) {
        System.out.println("operationImpl1 of ImplementationA : " + pMessage);
    }
    
    public void operationImpl2(Integer pNombre) {
        System.out.println("operationImpl2 of ImplementationA : " + pNombre);
    }
}