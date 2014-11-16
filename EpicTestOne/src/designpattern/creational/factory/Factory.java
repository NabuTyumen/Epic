package designpattern.creational.factory;

/**
 * Déclare la méthode de Creation.
 */
public abstract class Factory {
    
    private boolean pIsClasseA = false;

    /**
     * Méthode de Creation
     */
    public abstract AbstractClasse createClass(boolean pIsClasseA);
    
    /**
     * Méthode appelant la méthode de Creation.
     * Puis, effectuant une opération.
     */
    public void operation() {
        // Change la value afin de varier le paramètre
        // de la méthode de Creation
        pIsClasseA = !pIsClasseA;
        
        // Récupère une instance de classe "AbstractClasse"
        AbstractClasse lClasse = createClass(pIsClasseA);
        
        // Appel la méthode d'affichage de la classe
        // afin de savoir la classe concrète
        lClasse.displayClass();
    }
}
