package designpattern.behavioral.iterator;

/**
 * Sub-class de l'interface "Compose".
 */
public class ConcreteCompose implements Compose {

    // Component element of object "Compose"
    private String[] elements = {
            "Hello" , "everybody", ",", "What's", "up", "?"
    };

    /**
     * Returna object "Iterator" permettant 
     * de parcourir les elements 	
     */
    public Iterator createIterator() {
        return new ConcreteIterator(elements);
    }
}
