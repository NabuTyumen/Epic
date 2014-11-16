package designpattern.structural.proxy;

public class ProxyPatternMain {

    public static void main(String[] args) {
        // Création du "Proxy"
        Abstraction lProxy = new Proxy();
        
        // Appel de la méthode du "Proxy"
        lProxy.display();
        
        // Affichage : 
        // --> Méthode display() du Proxy : 
        // --> Création de l'objet Implementation au besoin
        // --> Appel de la méthode display() de l'objet Implementation
        // Méthode display() de la classe d'implementation
    }
}