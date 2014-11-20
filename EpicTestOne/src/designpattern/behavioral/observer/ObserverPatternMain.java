package designpattern.behavioral.observer;

public class ObserverPatternMain {

    public static void main(String[] args) {
        // Creation of the observed object
        ConcreteObserve lObserve = new ConcreteObserve();
        
        // Creation of 2 observers
        ConcreteObserverA lConcreteObserverA = new ConcreteObserverA();
        ConcreteObserverB lConcreteObserverB = new ConcreteObserverB();
        
        // Add observers 
        // to the list of the observers
        // of the observed object
        lObserve.addObs(lConcreteObserverA);
        lObserve.addObs(lConcreteObserverB);
        
        // Set observer of the observed object 
        lConcreteObserverA.setObserve(lObserve);
        lConcreteObserverB.setObserve(lObserve);
        
        // Display state of the two observers
        lConcreteObserverA.display();
        lConcreteObserverB.display();
        
        // Call of a method update
        // of the observed object
        lObserve.setvalue(4);
        
        // Display state of the 2 observers
        lConcreteObserverA.display();
        lConcreteObserverB.display();
        
        // Displayed :
        // ConcreteObserverA contains  0
        // ConcreteObserverB contains 0
        // ConcreteObserverA contains 4
        // ConcreteObserverB contains 4
    }
}
