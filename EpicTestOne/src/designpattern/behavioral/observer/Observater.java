package designpattern.behavioral.observer;

/**
 * Définit l'inteface d'un observateur
 */
public interface Observater {

    /**
     * Méthode appelée par l'objet observé
     * pour notifier une mise à jour
     */
    public void update();
}
