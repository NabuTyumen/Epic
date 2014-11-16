package designpattern.behavioral.observer;

/**
 * Implémentation d'un objet observé
 */
public class ConcreteObserve extends Observe {

    int value = 0;
    
    /**
     * Modifie une value de l'objet 
     * et notifie la nouvelle value
     * @param pvalue
     */
    public void setvalue(int pvalue) {
        value = pvalue;
        note();
    }
    
    /**
     * Retourne la value de l'objet
     * @return La value
     */
    public int getvalue() {
        return value;
    }
}