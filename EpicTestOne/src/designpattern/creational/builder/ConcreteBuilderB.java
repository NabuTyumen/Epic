package designpattern.creational.builder;

/**
 * Implement les methods permettant 
 * de créer les parties of the object complexe.
 */
public class ConcreteBuilderB extends Builder {

    /**
     * Method to set attribut1
     * Specify than attribut2 represent a dimension in inches
     */
    public void createAttribute1(String pAttribut1) {
        produit.setAttribut1(pAttribut1 + " (avec dimension en pouces)");
    }

    /**
     * Method to set attribut2
     * Store value in a Float with conversion in inches
     */
    public void createAttribute2(double pAttribut2) {
        produit.setAttribut2(new Double(pAttribut2 * 2.54));
    }
}