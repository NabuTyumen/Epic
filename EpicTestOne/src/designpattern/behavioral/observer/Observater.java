package designpattern.behavioral.observer;

/**
 * D�finit l'inteface d'un observateur
 */
public interface Observater {

    /**
     * M�thode appel�e par l'objet observ�
     * pour notifier une mise � jour
     */
    public void update();
}
