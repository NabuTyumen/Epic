package designpattern.creational.builder;

/**
 * Définit l'interface des méthodes permettant  
 * de créer les différentes partie
 * de l'objet complexe.
 */
public abstract class Builder {

    protected ComplexObject produit;
    
    /**
     * Crée un nouveau produit
     * Aucune des parties n'est créée
     * à ce moment là.
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
    
    // Les méthodes de Creation des parties 
    
    public abstract void createAttribute1(String pAttribut1);
    public abstract void createAttribute2(double pAttribut2);
}
