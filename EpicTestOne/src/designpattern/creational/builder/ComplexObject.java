package designpattern.creational.builder;

/**
 * The complexe object
 * In this example, once could assume that
 * attribut1 is  label
 * and attribut2 as a dimension
 * The class of the attribut2 could change depending of the Builder
 */
public class ComplexObject {

    //  attributes of the complex object
    private String attribut1;
    private Number attribut2;
    
    // setting method of the attributes
    public void setAttribut1(String pAttribut1) {
        attribut1 = pAttribut1;
    }
    
    public void setAttribut2(Number pAttribut2) {
    	attribut2 = pAttribut2;
    }
    
    /**
     * Method to display state of the object
     * to show the different setting. 
     */
    public void display() {
        System.out.println("Complex Object : ");
        System.out.println("\t- attribute1 : " + attribut1);
        System.out.println("\t- attribute2 : " + attribut2);
        System.out.println("\t- classe of attribute2 : " + attribut2.getClass());
    }
}
