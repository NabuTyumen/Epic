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
        // Sauvegarde l'�tat (4) dans le "Gardien" par le "Memento"
        lKeeper.addMemento(lCreator.saveInMemento());
        // Change l'�tat (4 * 4 = 16)
        lCreator.next();
        // Sauvegarde l'�tat (16) dans le "Gardien" par le "Memento"
        lKeeper.addMemento(lCreator.saveInMemento());
        // Affiche l'�tat (16)
        lCreator.display();
        // R�cup�re l'�tat (4) de l'index 1 depuis le "Gardien"
        Creator.Memento lMemento1 = lKeeper.getMemento(1);
        // Restaure l'�tat depuis le "Memento"
        lCreator.restoreFromMemento(lMemento1);
        // Affiche l'�tat (4)
        lCreator.display();
        
        // Display : 
        // The state is : 2
        // The state is : 16
        // The state is : 4
    }
}
