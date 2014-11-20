package designpattern.creational.factory;

public class FactoryMethodPatternMain {

    public static void main(String[] args) {
        // Creation of the factories
        Factory lFactoryA = new FactoryA();
        Factory lFactoryB = new FactoryB();
    
        // Calling this method with FactoryA will cause 
        // instantiation of two different classes 
        System.out.println("With FactoryA : ");
        lFactoryA.operation();
        lFactoryA.operation();
        lFactoryA.operation();
        // Calling this method with FactoryB will cause 
        // instantiation of always the same class 
        System.out.println("With FactoryB : ");
        lFactoryB.operation();
        lFactoryB.operation();
        lFactoryB.operation();
        
        // Displayed : 
        //With FactoryA : 
        //class designpattern.creational.factory.ClassA
        //class designpattern.creational.factory.ClassB
        //class designpattern.creational.factory.ClassA
        //With FactoryB : 
        //class designpattern.creational.factory.ClassB
        //class designpattern.creational.factory.ClassB
        //class designpattern.creational.factory.ClassB
    }
}
