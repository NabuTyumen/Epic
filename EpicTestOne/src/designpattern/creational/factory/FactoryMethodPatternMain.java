package designpattern.creational.factory;

public class FactoryMethodPatternMain {

    public static void main(String[] args) {
        // Cr�ation des fabriques
        Factory lFactoryA = new FactoryA();
        Factory lFactoryB = new FactoryB();
    
        // L'appel de cette m�thode avec FabriqueA provoquera 
        // l'instanciation de deux classes diff�rentes
        System.out.println("With FabriqueA : ");
        lFactoryA.operation();
        lFactoryA.operation();
        lFactoryA.operation();
        // L'appel de cette m�thode avec FabriqueB provoquera 
        // toujours l'instanciation de la m�me classe
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
