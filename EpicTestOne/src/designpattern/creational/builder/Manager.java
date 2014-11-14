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
     * Cr�e un objet.
     * Appelle les m�thodes de cr�ation 
     * des parties du "Monteur".
     */
    public ComplexObject createObject() {
        builder.createObject();
        
        builder.createAttribute1("libelle de l'objet");
        builder.createAttribute2(12);
        
        return builder.getObjet();
    }
}
