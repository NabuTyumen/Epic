package designpattern.creational.builder;

/**
 * Impl�mente les m�thodes permettant 
 * de cr�er les parties de l'objet complexe.
 */
public class ConcreteBuilderA extends Builder {

    /**
     * M�thode de cr�ation de l'attribut attribut1
     * Pr�cise que l'attibut2 repr�sente une dimention en centim�tres
     */
    public void createAttribute1(String pAttribut1) {
        produit.setAttribut1(pAttribut1 + " (avec dimension en centim�tre)");
    }

    /**
     * M�thode de cr�ation de l'attribut attribut2
     * Stocke la valeur dans un Float sans modification
     */
    public void createAttribute2(double pAttribut2) {
        produit.setAttribut2(new Float(pAttribut2));
    }
}
