package designpattern.structural.proxy;

public class ProxyPatternMain {

    public static void main(String[] args) {
        // Creation of the"Proxy"
        Abstraction lProxy = new Proxy();
        
        // Call of method of the "Proxy"
        lProxy.display();
        
        // Displayed : 
        // --> Method display() of Proxy : 
        // --> Creation of the object Implementation when needed
        // --> Call of the method display() of the object Implementation
        // Method display() of the implemented class
    }
}