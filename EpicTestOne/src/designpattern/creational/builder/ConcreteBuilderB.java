package designpattern.creational.builder;

/**
 * Impl�mente les m�thodes permettant 
 * de cr�er les parties de l'objet complexe.
 */
public class ConcreteBuilderB extends Builder {

    /**
     * M�thode de cr�ation de l'attribut attribut1
     * Pr�cise que l'attibut2 repr�sente une dimention en pouces
     */
    public void createAttribute1(String pAttribut1) {
        produit.setAttribut1(pAttribut1 + " (avec dimension en pouces)");
    }

    /**
     * M�thode de cr�ation de l'attribut attribut2
     * Stocke la valeur dans un Doucle en le convertissant en pouces
     */
    public void createAttribute2(double pAttribut2) {
        produit.setAttribut2(new Double(pAttribut2 * 2.54));
    }
}