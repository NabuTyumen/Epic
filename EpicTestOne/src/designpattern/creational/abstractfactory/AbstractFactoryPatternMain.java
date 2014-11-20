package designpattern.creational.abstractfactory;

public class AbstractFactoryPatternMain {

    public static void main(String[] args) {
        // Creation of factories
        AbstractFactory lFactory1 = new ConcreteFactoryA();
        AbstractFactory lFactory2 = new ConcreteFactoryB();
        
        // Creation of 2 "AbstractClasse" from each factory
        AbstractClass lClasse1 = lFactory1.createClass();
        AbstractClass lClasse2 = lFactory2.createClass();
        
        // Call method from "AbstractClasse" displaying a message
        // The message is to check that each "AbstractClasse"
        // are in fact different classes
        lClasse1.displayClass();
        lClasse2.displayClass();
        
        // --------------------------
        // Displayed : 
        // Objet de classe 'ClasseA'
        // Objet de classe 'ClasseB'
    }
}
