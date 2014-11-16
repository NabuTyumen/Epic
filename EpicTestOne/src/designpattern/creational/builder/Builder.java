package designpattern.creational.builder;

/**
 * D�finit l'interface des m�thodes permettant  
 * de cr�er les diff�rentes partie
 * de l'objet complexe.
 */
public abstract class Builder {

    protected ComplexObject produit;
    
    /**
     * Cr�e un nouveau produit
     * Aucune des parties n'est cr��e
     * � ce moment l�.
     */
    public void createObject() {
        produit = new ComplexObject();
    }
    
    /**
     * Retourne l'objet une fois fini.
     */
    public ComplexObject getObjet() {
        return produit;
    }
    
    // Les m�thodes de Creation des parties 
    
    public abstract void createAttribute1(String pAttribut1);
    public abstract void createAttribute2(double pAttribut2);
}
