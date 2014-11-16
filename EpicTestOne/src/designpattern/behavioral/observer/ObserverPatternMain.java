package designpattern.behavioral.observer;

public class ObserverPatternMain {

    public static void main(String[] args) {
        // Creation de l'objet observ�
        ConcreteObserve lObserve = new ConcreteObserve();
        
        // Creation de 2 observateurs
        ConcreteObservaterA lConcreteObservateurA = new ConcreteObservaterA();
        ConcreteObservaterB lConcreteObservateurB = new ConcreteObservaterB();
        
        // Ajout des observateurs 
        // � la liste des observateurs
        // de l'objet observ�
        lObserve.addObs(lConcreteObservateurA);
        lObserve.addObs(lConcreteObservateurB);
        
        // Fixe l'objet observ� des observateurs
        lConcreteObservateurA.setObserve(lObserve);
        lConcreteObservateurB.setObserve(lObserve);
        
        // Affiche l'�tat des deux observateurs
        lConcreteObservateurA.display();
        lConcreteObservateurB.display();
        
        // Appel d'un m�thode de mise � jour
        // de l'objet observ�
        lObserve.setvalue(4);
        
        // Affiche l'�tat des deux observateurs
        lConcreteObservateurA.display();
        lConcreteObservateurB.display();
        
        // Affichage :
        // ConcreteObservateurA contient 0
        // ConcreteObservateurB contient 0
        // ConcreteObservateurA contient 4
        // ConcreteObservateurB contient 4
    }
}
