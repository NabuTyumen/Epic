package designpattern.creational.builder;

/**
 * Construct the object using the methods of a "Builder".
 */
public class Manager {
    private Builder builder;
    
    Manager(Builder pMonteur) {
        builder = pMonteur;
    }
    
    /**
     * Crée un objet.
     * Appelle les méthodes de création 
     * des parties du "Monteur".
     */
    public ComplexObject createObject() {
        builder.createObject();
        
        builder.createAttribute1("libelle de l'objet");
        builder.createAttribute2(12);
        
        return builder.getObjet();
    }
}
