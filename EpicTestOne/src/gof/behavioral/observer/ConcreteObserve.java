package gof.behavioral.observer;

/**
 * Implementation of a observed object
 */
public class ConcreteObserve extends Observe {

    int value = 0;
    
    /**
     * Change a object's value 
     * and notify the new value
     * @param pvalue
     */
    public void setvalue(int pvalue) {
        value = pvalue;
        note();
    }
    
    /**
     * Return object's value
     * @return value
     */
    public int getvalue() {
        return value;
    }
}