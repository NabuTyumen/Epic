package designpattern.behavioral.observer;
/**
 * Sub-class concrete of "Observer"
 */
public class ConcreteObserverB implements Observer {

    private int value = 0;
    private ConcreteObserve observe;
    
    /**
     * Set observed object 
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
        System.out.println("ConcreteObserverB contains " + value);
    }
}
