package designpattern.structural.proxy;

public class ProxyPatternMain {

    public static void main(String[] args) {
        // Cr�ation du "Proxy"
        Abstraction lProxy = new Proxy();
        
        // Appel de la m�thode du "Proxy"
        lProxy.display();
        
        // Affichage : 
        // --> M�thode display() du Proxy : 
        // --> Cr�ation de l'objet Implementation au besoin
        // --> Appel de la m�thode display() de l'objet Implementation
        // M�thode display() de la classe d'implementation
    }
}