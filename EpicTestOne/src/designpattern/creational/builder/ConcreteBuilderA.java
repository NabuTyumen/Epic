package designpattern.creational.builder;

/**
 * Implement methods to create the parts of the object complexe.
 */
public class ConcreteBuilderA extends Builder {

    /**
     * Method to set attribut1
     * Specify than attribut2 represent a dimension in centimeter
     */
    public void createAttribute1(String pAttribut1) {
        produit.setAttribut1(pAttribut1 + " (with dimension in centimeter)");
    }

    /**
     * Method to set attribut2
     * Store value in a Float without modification
     */
    public void createAttribute2(double pAttribut2) {
        produit.setAttribut2(new Float(pAttribut2));
    }
}
