package designpattern.structural.flyweight;

public class FlyweightPatternMain {

    public static void main(String[] args) {
        // Instancie la fabrique
        PoidsMoucheFabrique lFlyweightFactory = new PoidsMoucheFabrique();
        
        // Demande des "PoidsMouche" qui sont partagés
        Flyweight lFlyweight1 = lFlyweightFactory.getPoidsMouche("Bonjour");
        Flyweight lFlyweight1Bis = lFlyweightFactory.getPoidsMouche("Bonjour");

        // Affiche ces deux "PoidsMouche"
        lFlyweight1.display("Contexte1");
        lFlyweight1Bis.display("Contexte1Bis");

        // Affiche si les références pointent sur la même instance
        // Cela est logique puisque c'est le principe de l'instance partagée.
        System.out.print("lFlyweight1 == lFlyweight1Bis : ");
        System.out.println(lFlyweight1 == lFlyweight1Bis);

        // Demande un "PoidsMouche" qui ne fait pas partie des existants
        Flyweight lFlyweight2 = lFlyweightFactory.getPoidsMouche("BonjouR");
        Flyweight lFlyweight2Bis = lFlyweightFactory.getPoidsMouche("BonjouR");

        // Affiche ces deux "PoidsMouche"
        lFlyweight2.display("Contexte2");
        lFlyweight2Bis.display("Contexte2Bis");
        
        // Demande et affiche un "PoidsMouche" non partagé
        Flyweight lFlyweight3 = lFlyweightFactory.getPoidsMouche("value1", "value2");
        lFlyweight3.display(null);
                
        // Affichage : 
        // --> Retourne un PoidsMouche (Bonjour) partagé déjà existant
        // --> Retourne un PoidsMouche (Bonjour) partagé déjà existant
        // PoidsMouche avec la value : Bonjour et contexte : Contexte1
        // PoidsMouche avec la value : Bonjour et contexte : Contexte1Bis
        // lFlyweight1 == lFlyweight1Bis : true
        // --> Retourne un PoidsMouche (BonjouR) partagé non déjà existant
        // --> Retourne un PoidsMouche (BonjouR) partagé déjà existant
        // PoidsMouche avec la value : BonjouR et contexte : Contexte2
        // PoidsMouche avec la value : BonjouR et contexte : Contexte2Bis
        // --> Retourne un PoidsMouche (value1, value2) non partagé
        // PoidsMouche avec la value1 : value1 avec la value2 : value2
    }
}