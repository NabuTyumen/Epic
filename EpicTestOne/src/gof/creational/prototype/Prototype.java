package gof.creational.prototype;

/**
 * Define l'interface of the object à dupliquer.
 */
public abstract class Prototype implements Cloneable {

    protected String text;
    
    /**
     * Constructor of the class.
     * @param pTexte
     */
    public Prototype(String pTexte) {
        text = pTexte;
    }
    
    /**
     * The method clone is protected into Object.
     * We must substitute to make it visible.
     * In addition the class must implement interface Cloneable. 
     * Since Java5, it is possible to return a sub-type of Object.
     */
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
    
    public void setTexte(String pTexte) {
        text = pTexte;
    }
    
    /**
     * Display method of the object's information.
     */
    public abstract void display();
}
