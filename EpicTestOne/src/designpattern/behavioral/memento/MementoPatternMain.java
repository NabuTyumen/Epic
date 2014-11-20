package designpattern.behavioral.memento;
public class MementoPatternMain {

    public static void main(String[] args) {
        // Creation of the Keeper
        Keeper lKeeper = new Keeper();
        // Creation of the Creator
        Creator lCreator = new Creator();
        
        // Save state (2) in the Keeper via the "Memento"
        lKeeper.addMemento(lCreator.saveInMemento());
        // Display state (2)
        lCreator.display();
        // Change state (2 * 2 = 4)
        lCreator.next();
        // Save state (4) of the "Keeper" in the "Memento"
        lKeeper.addMemento(lCreator.saveInMemento());
        // Change state (4 * 4 = 16)
        lCreator.next();
        // Save state (16) dans le "Keeper" par le "Memento"
        lKeeper.addMemento(lCreator.saveInMemento());
        // Display state (16)
        lCreator.display();
        // Retrieve state (4) of index 1 from the "Keeper"
        Creator.Memento lMemento1 = lKeeper.getMemento(1);
        // Restore state from "Memento"
        lCreator.restoreFromMemento(lMemento1);
        // Display state (4)
        lCreator.display();
        
        // Display : 
        // The state is : 2
        // The state is : 16
        // The state is : 4
    }
}
