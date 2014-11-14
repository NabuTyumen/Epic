package designpattern.behavioral.memento;

import java.util.LinkedList;
import java.util.List;

/**
 * Keep the "Memento".
 * Return a saved "Memento" 
 */
public class Keeper {

    // List of "Memento"
    private List<Creator.Memento> list = new LinkedList<Creator.Memento>();
    
    /**
     * Add a "Memento" to the list
     * @param pMemento
     */
    public void addMemento(Creator.Memento pMemento) {
        list.add(pMemento);
    }
    
    /**
     * Return the "Memento" that fit the index
     * @param pIndex
     * @return
     */
    public Creator.Memento getMemento(int pIndex) {
        return list.get(pIndex);
    }
}