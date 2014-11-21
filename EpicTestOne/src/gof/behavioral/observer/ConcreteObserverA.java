package gof.behavioral.observer;
/**
 * Sub-class concrete of "Observer"
 */
public class ConcreteObserverA implements Observer {

    private int value = 0;
    private ConcreteObserve observe;
    
    /**
     * Set object observed
     * @param pObserve
     */
    public void setObserve(ConcreteObserve pObserve) {
        observe = pObserve;
    }
    
    /**
     * Method call by observed object 
     * to notify a update
     */
    public void update() {
        value = observe.getvalue();
    }

    /**
     * Display value
     */
    public void display() {
        System.out.println("ConcreteObserverA contains " + value);
    }
}
