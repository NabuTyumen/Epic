package designpattern.creational.builder;

/**
 * Implémente les méthodes permettant 
 * de créer les parties de l'objet complexe.
 */
public class ConcreteBuilderA extends Builder {

    /**
     * Méthode de création de l'attribut attribut1
     * Précise que l'attibut2 représente une dimention en centimètres
     */
    public void createAttribute1(String pAttribut1) {
        produit.setAttribut1(pAttribut1 + " (avec dimension en centimètre)");
    }

    /**
     * Méthode de création de l'attribut attribut2
     * Stocke la valeur dans un Float sans modification
     */
    public void createAttribute2(double pAttribut2) {
        produit.setAttribut2(new Float(pAttribut2));
    }
}
