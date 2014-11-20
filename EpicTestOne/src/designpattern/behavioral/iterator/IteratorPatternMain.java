package designpattern.behavioral.iterator;

public class IteratorPatternMain {

    public static void main(String[] args) {
        // Creation of object "Compose"
        Compose lCompose = new ConcreteCompose();
        // Creation of object "Iterator"
        Iterator lIterator = lCompose.createIterator();
        
        // Browse the elements of "Compose"
        // using "Iterator"
        while(!lIterator.end()) {
            System.out.println(lIterator.next());
        }
        
        // Displayed : 
        // Bonjour
        // le
        // monde
    }
}