package designpattern.behavioral.observer;
/**
 * Sous-classe concr�te de "Observateur"
 */
public class ConcreteObservaterA implements Observater {

    private int value = 0;
    private ConcreteObserve observe;
    
    /**
     * Fixe l'objet observ�
     * @param pObserve
     */
    public void setObserve(ConcreteObserve pObserve) {
        observe = pObserve;
    }
    
    /**
     * M�thode appel�e par l'objet observ�
     * pour notifier une mise � jour
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
