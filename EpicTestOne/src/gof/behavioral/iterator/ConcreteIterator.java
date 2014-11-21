package gof.behavioral.iterator;

/**
 * Sub-class of interface "Iterator".
 */
public class ConcreteIterator implements Iterator {

    private String[] elements;
    private int index = 0;
    
    public ConcreteIterator(String[] pElements) {
        elements = pElements;
    }
    
    /**
     * Return the element
     * then increment index
     */
    public String next() {
        return elements[index++];
    }
    
    /**
     * Si l'index est sup�rieur ou �gal
     * � la taille du tableau,
     * on consid�re que l'on a fini
     * de parcourir les elements
     */
    public boolean end() {
        return index >= elements.length;
    }
}	
