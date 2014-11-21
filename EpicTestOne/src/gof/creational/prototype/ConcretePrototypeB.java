package gof.creational.prototype;

/**
 * Subus-class of Prototype.
 */
public class ConcretePrototypeB extends Prototype {
    
    public ConcretePrototypeB(String pTexte) {
        super(pTexte);
    }
    
    /**
     * Display method.
     * Indicate that object is ConcretePrototypeB 
     * and the value of the text attribute. 
     */
    public void display() {
        System.out.println("ConcretePrototypeB with text : " + text);
    }
}
