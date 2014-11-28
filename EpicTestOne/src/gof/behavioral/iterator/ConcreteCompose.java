package gof.behavioral.iterator;

/**
 * Sub-class of interface "Compose".
 */
public class ConcreteCompose implements Compose {

    // Component element of object "Compose"
    private String[] elements = {
            "Hello" , "everybody", ",", "What's", "up", "?"
    };

    /**
     * Return  object "Iterator" to 
     * browse elements 	
     */
    public Iterator createIterator() {
        return new ConcreteIterator(elements);
    }
}
