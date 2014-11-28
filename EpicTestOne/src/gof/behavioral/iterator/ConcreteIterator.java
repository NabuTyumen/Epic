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
     * If index is greater or equal
     * to the size of the table
     * then end of the browsing
     */
    public boolean end() {
        return index >= elements.length;
    }
}	
