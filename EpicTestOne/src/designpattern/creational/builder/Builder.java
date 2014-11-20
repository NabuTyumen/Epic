package designpattern.creational.builder;

/**
 * Define interface of the methods   
 * to create the different parts
 * of the complex object.
 */
public abstract class Builder {

    protected ComplexObject produit;
    
    /**
     * Create a new product 
     * None of the parts created yet
     */
    public void createObject() {
        produit = new ComplexObject();
    }
    
    /**
     * Return l'object une fois fini.
     */
    public ComplexObject getObjet() {
        return produit;
    }
    
    // Les methods de Creation des parties 
    
    public abstract void createAttribute1(String pAttribut1);
    public abstract void createAttribute2(double pAttribut2);
}
