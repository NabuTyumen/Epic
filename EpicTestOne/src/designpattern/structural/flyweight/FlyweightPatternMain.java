package designpattern.structural.flyweight;

public class FlyweightPatternMain {

    public static void main(String[] args) {
        // Instancie la fabrique
        PoidsMoucheFabrique lFlyweightFactory = new PoidsMoucheFabrique();
        
        // Demande des "PoidsMouche" qui sont partag�s
        Flyweight lFlyweight1 = lFlyweightFactory.getPoidsMouche("Bonjour");
        Flyweight lFlyweight1Bis = lFlyweightFactory.getPoidsMouche("Bonjour");

        // Affiche ces deux "PoidsMouche"
        lFlyweight1.display("Contexte1");
        lFlyweight1Bis.display("Contexte1Bis");

        // Affiche si les r�f�rences pointent sur la m�me instance
        // Cela est logique puisque c'est le principe de l'instance partag�e.
        System.out.print("lFlyweight1 == lFlyweight1Bis : ");
        System.out.println(lFlyweight1 == lFlyweight1Bis);

        // Demande un "PoidsMouche" qui ne fait pas partie des existants
        Flyweight lFlyweight2 = lFlyweightFactory.getPoidsMouche("BonjouR");
        Flyweight lFlyweight2Bis = lFlyweightFactory.getPoidsMouche("BonjouR");

        // Affiche ces deux "PoidsMouche"
        lFlyweight2.display("Contexte2");
        lFlyweight2Bis.display("Contexte2Bis");
        
        // Demande et affiche un "PoidsMouche" non partag�
        Flyweight lFlyweight3 = lFlyweightFactory.getPoidsMouche("value1", "value2");
        lFlyweight3.display(null);
                
        // Affichage : 
        // --> Retourne un PoidsMouche (Bonjour) partag� d�j� existant
        // --> Retourne un PoidsMouche (Bonjour) partag� d�j� existant
        // PoidsMouche avec la value : Bonjour et contexte : Contexte1
        // PoidsMouche avec la value : Bonjour et contexte : Contexte1Bis
        // lFlyweight1 == lFlyweight1Bis : true
        // --> Retourne un PoidsMouche (BonjouR) partag� non d�j� existant
        // --> Retourne un PoidsMouche (BonjouR) partag� d�j� existant
        // PoidsMouche avec la value : BonjouR et contexte : Contexte2
        // PoidsMouche avec la value : BonjouR et contexte : Contexte2Bis
        // --> Retourne un PoidsMouche (value1, value2) non partag�
        // PoidsMouche avec la value1 : value1 avec la value2 : value2
    }
}