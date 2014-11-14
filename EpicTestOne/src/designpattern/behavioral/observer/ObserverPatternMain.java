package designpattern.behavioral.observer;

public class ObserverPatternMain {

    public static void main(String[] args) {
        // Cr�ation de l'objet observ�
        ConcreteObserve lObserve = new ConcreteObserve();
        
        // Cr�ation de 2 observateurs
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
        lConcreteObservateurA.afficher();
        lConcreteObservateurB.afficher();
        
        // Appel d'un m�thode de mise � jour
        // de l'objet observ�
        lObserve.setValeur(4);
        
        // Affiche l'�tat des deux observateurs
        lConcreteObservateurA.afficher();
        lConcreteObservateurB.afficher();
        
        // Affichage :
        // ConcreteObservateurA contient 0
        // ConcreteObservateurB contient 0
        // ConcreteObservateurA contient 4
        // ConcreteObservateurB contient 4
    }
}
