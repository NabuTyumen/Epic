package designpattern.structural.composite;

/**
 * Define interface of a object 
 * that could be a component of another object in the tree
 */
public abstract class Component {

    // Name of the "Component"
    protected String name;
    
    /**
     * Constructor
     * @param pNom Name of the "Component"
     */
    public Component(final String pNom) {
        name = pNom;
    }
    
    /**
     * Opération commune à tous les "Composant"
     */
    public abstract void operation();
}