package designpattern.behavioral.observer;
/**
 * Sous-classe concrète de "Observateur"
 */
public class ConcreteObservaterA implements Observater {

    private int valeur = 0;
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
        valeur = observe.getValeur();
    }

    /**
     * Affiche la valeur
     */
    public void afficher() {
        System.out.println("ConcreteObservateurA contient " + valeur);
    }
}
