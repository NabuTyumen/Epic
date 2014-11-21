package gof.creational.builder;

/**
 * Construct a object using the methods of a "Builder".
 */
public class Manager {
    private Builder builder;
    
    Manager(Builder pMonteur) {
        builder = pMonteur;
    }
    
    /**
     * Create a object.
     * Call creating methods of "Builder".
     */
    public ComplexObject createObject() {
        builder.createObject();
        
        builder.createAttribute1("label of the object");
        builder.createAttribute2(12);
        
        return builder.getObjet();
    }
}
