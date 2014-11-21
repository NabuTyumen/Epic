package gof.behavioral.observer;

/**
 * Define the inteface of a observer
 */
public interface Observer {

    /**
     * Method call by observed object 
     * to notify a update
     */
    public void update();
}
