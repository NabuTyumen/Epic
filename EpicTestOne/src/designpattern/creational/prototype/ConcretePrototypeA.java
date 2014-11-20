package designpattern.creational.prototype;

/**
 * Sub-class of Prototype.
 */
public class ConcretePrototypeA extends Prototype {
    
    public ConcretePrototypeA(String pTexte) {
        super(pTexte);
    }

    /**
     * Display method.
     * Indicate that object is ConcretePrototypeA 
     * and the value of the text attribute. 
     */
    public void display() {
        System.out.println("ConcretePrototypeA with text : " + text);
    }
}
