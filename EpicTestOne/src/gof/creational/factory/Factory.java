package gof.creational.factory;

/**
 * Statement of the creation method
 */
public abstract class Factory {
    
    private boolean pIsClasseA = false;

    /**
     * Creation method 
     */
    public abstract AbstractClasse createClass(boolean pIsClasseA);
    
    /**
     * Method calling creation method.
     * Then, processing a operation.
     */
    public void operation() {
        // Update the  value to varying a parameter
        // of the creation method 
        pIsClasseA = !pIsClasseA;
        
        // Retrieve a instance of "AbstractClasse"
        AbstractClasse lClasse = createClass(pIsClasseA);
        
        // Call the display method of the class
        // to show the name of the concrete class
        lClasse.displayClass();
    }
}
