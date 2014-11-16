package designpattern.structural.bridge;

/**
 * Sous-classe concr�te de l'impl�mentation
 */
public class ImplementationB implements Implementation {

    public void operationImpl1(String pMessage) {
        System.out.println("operationImpl1 de ImplementationB : " + pMessage);
    }
    
    public void operationImpl2(Integer pNombre) {
        System.out.println("operationImpl2 de ImplementationB : " + pNombre);
    }
}
