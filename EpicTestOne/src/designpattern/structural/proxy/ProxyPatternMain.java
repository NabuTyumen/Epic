package designpattern.structural.proxy;

public class ProxyPatternMain {

    public static void main(String[] args) {
        // Cr�ation du "Proxy"
        Abstraction lProxy = new Proxy();
        
        // Appel de la method du "Proxy"
        lProxy.display();
        
        // Displayed : 
        // --> Method display() du Proxy : 
        // --> Cr�ation of the object Implementation au besoin
        // --> Appel de la method display() of the object Implementation
        // Method display() de la classe d'implementation
    }
}