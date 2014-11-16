package designpattern.creational.factory;

/**
 * D�clare la m�thode de Creation.
 */
public abstract class Factory {
    
    private boolean pIsClasseA = false;

    /**
     * M�thode de Creation
     */
    public abstract AbstractClasse createClass(boolean pIsClasseA);
    
    /**
     * M�thode appelant la m�thode de Creation.
     * Puis, effectuant une op�ration.
     */
    public void operation() {
        // Change la value afin de varier le param�tre
        // de la m�thode de Creation
        pIsClasseA = !pIsClasseA;
        
        // R�cup�re une instance de classe "AbstractClasse"
        AbstractClasse lClasse = createClass(pIsClasseA);
        
        // Appel la m�thode d'affichage de la classe
        // afin de savoir la classe concr�te
        lClasse.displayClass();
    }
}
