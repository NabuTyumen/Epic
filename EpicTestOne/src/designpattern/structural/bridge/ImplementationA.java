package designpattern.structural.bridge;

/**
 * Sous-classe concr�te de l'impl�mentation
 */
public class ImplementationA implements Implementation {

    public void operationImpl1(String pMessage) {
        System.out.println("operationImpl1 de ImplementationA : " + pMessage);
    }
    
    public void operationImpl2(Integer pNombre) {
        System.out.println("operationImpl2 de ImplementationA : " + pNombre);
    }
}