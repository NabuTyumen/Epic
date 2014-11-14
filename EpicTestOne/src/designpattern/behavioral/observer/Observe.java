package designpattern.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Interface d'objet observ�
 */
public class Observe {

    // Liste des observateurs
    private List<Observater> listeObservateurs = 
            new LinkedList<Observater>();
    
    /**
     * Ajouter un observateur de la liste
     * @param pObservateur
     */
    public void addObs(Observater pObservateur) {
        listeObservateurs.add(pObservateur);
    }
    
    /**
     * Supprimer un observateur de la liste
     * @param pObservateur
     */
    public void deleteObs(Observater pObservateur) {
        listeObservateurs.remove(pObservateur);
    }
    
    /**
     * Notifier � tous les observateurs de la liste
     * que l'objet � �t� mis � jour.
     */
    protected void note() {
        for(Observater lObservateur : listeObservateurs) {
            lObservateur.update();
        }
    }
}