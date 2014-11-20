package designpattern.creational.prototype;

public class PrototypePatternMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        // Instanciate a object ConcretePrototypeA
        // and a other ConcretePrototypeB
        // in "traditional manner".
        Prototype lPrototypeA = new ConcretePrototypeA("Original");
        Prototype lPrototypeB = new ConcretePrototypeB("Original");
        
        // Duplicate the objects previously created
        Prototype lPrototypeAClone = lPrototypeA.clone();
        Prototype lPrototypeBClone = lPrototypeB.clone();
        
        // Display objects : 
        // the clones are identical to the original
        lPrototypeA.display();
        lPrototypeAClone.display();
        lPrototypeB.display();
        lPrototypeBClone.display();
        
        // Update the clones
        lPrototypeAClone.setTexte("Clone (in fact)");
        lPrototypeBClone.setTexte("Clone (in fact)");
        
        // Highlights that the clones
        // are instance apart.
        lPrototypeA.display();
        lPrototypeAClone.display();
        lPrototypeB.display();
        lPrototypeBClone.display();
        
        // Displayed :
      //ConcretePrototypeA with text : Original
      //ConcretePrototypeA with text : Original
      //ConcretePrototypeB with text : Original
      //ConcretePrototypeB with text : Original
      //ConcretePrototypeA with text : Original
      //ConcretePrototypeA with text : Clone (in fact)
      //ConcretePrototypeB with text : Original
      //ConcretePrototypeB with text : Clone (in fact)
    }
}