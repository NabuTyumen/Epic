package designpattern.behavioral.observer;
/**
 * Sous-classe concrète de "Observateur"
 */
public class ConcreteObservaterA implements Observater {

    private int value = 0;
    private ConcreteObserve observe;
    
    /**
     * Fixe l'objet observé
     * @param pObserve
     */
    public void setObserve(ConcreteObserve pObserve) {
        observe = pObserve;
    }
    
    /**
     * Méthode appelée par l'objet observé
     * pour notifier une mise à jour
     */
    public void update() {
        value = observe.getvalue();
    }

    /**
     * Affiche la value
     */
    public void display() {
        System.out.println("ConcreteObservateurA contient " + value);
    }
}
