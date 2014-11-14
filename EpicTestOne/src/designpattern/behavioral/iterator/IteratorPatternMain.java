package designpattern.behavioral.iterator;

public class IteratorPatternMain {

    public static void main(String[] args) {
        // Creation of object "Compose"
        Compose lCompose = new ConcreteCompose();
        // Creation of object "Iterateur"
        Iterateur lIterateur = lCompose.createIterateur();
        
        // Browse the elements of "Compose"
        // using "Iterateur"
        while(!lIterateur.end()) {
            System.out.println(lIterateur.next());
        }
        
        // Affichage : 
        // Bonjour
        // le
        // monde
    }
}