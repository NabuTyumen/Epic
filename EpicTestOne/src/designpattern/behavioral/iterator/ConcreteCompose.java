package designpattern.behavioral.iterator;

/**
 * Sous-classe de l'interface "Compose".
 */
public class ConcreteCompose implements Compose {

    // Component element of object "Compose"
    private String[] elements = {
            "Hello" , "everybody", ",", "What's", "up", "?"
    };

    /**
     * Returna object "Iterateur" permettant 
     * de parcourir les éléments 	
     */
    public Iterateur createIterateur() {
        return new ConcreteIterateur(elements);
    }
}
