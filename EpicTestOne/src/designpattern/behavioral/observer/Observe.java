package designpattern.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Interface d'observed object
 */
public class Observe {

    // list des observers
    private List<Observer> listObservers = 
            new LinkedList<Observer>();
    
    /**
     * Add a observer to the list
     * @param pObserver
     */
    public void addObs(Observer pObserver) {
        listObservers.add(pObserver);
    }
    
    /**
     * Delete a observer from the list
     * @param pObserver
     */
    public void deleteObs(Observer pObserver) {
        listObservers.remove(pObserver);
    }
    
    /**
     * Notify to all the list's observers 
     * that the object was updated.
     */
    protected void note() {
        for(Observer lObserver : listObservers) {
            lObserver.update();
        }
    }
}