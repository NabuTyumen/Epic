package designpattern.creational.factory;

public class FactoryMethodPatternMain {

    public static void main(String[] args) {
        // Création des fabriques
        Factory lFactoryA = new FactoryA();
        Factory lFactoryB = new FactoryB();
    
        // L'appel de cette méthode avec FabriqueA provoquera 
        // l'instanciation de deux classes différentes
        System.out.println("With FabriqueA : ");
        lFactoryA.operation();
        lFactoryA.operation();
        lFactoryA.operation();
        // L'appel de cette méthode avec FabriqueB provoquera 
        // toujours l'instanciation de la même classe
        System.out.println("Avec la FabriqueB : ");
        lFactoryB.operation();
        lFactoryB.operation();
        lFactoryB.operation();
        
        // Affichage : 
        // Avec la FabriqueA : 
        // Objet de classe 'ClasseA'
        // Objet de classe 'ClasseB'
        // Objet de classe 'ClasseA'
        // Avec la FabriqueB : 
        // Objet de classe 'ClasseB'
        // Objet de classe 'ClasseB'
        // Objet de classe 'ClasseB'
    }
}
