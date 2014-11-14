package designpattern.behavioral.observer;

/**
 * Impl�mentation d'un objet observ�
 */
public class ConcreteObserve extends Observe {

    int valeur = 0;
    
    /**
     * Modifie une valeur de l'objet 
     * et notifie la nouvelle valeur
     * @param pValeur
     */
    public void setValeur(int pValeur) {
        valeur = pValeur;
        note();
    }
    
    /**
     * Retourne la valeur de l'objet
     * @return La valeur
     */
    public int getValeur() {
        return valeur;
    }
}