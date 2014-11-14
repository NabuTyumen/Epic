package designpattern.behavioral.observer;

public class ObserverPatternMain {

    public static void main(String[] args) {
        // Création de l'objet observé
        ConcreteObserve lObserve = new ConcreteObserve();
        
        // Création de 2 observateurs
        ConcreteObservaterA lConcreteObservateurA = new ConcreteObservaterA();
        ConcreteObservaterB lConcreteObservateurB = new ConcreteObservaterB();
        
        // Ajout des observateurs 
        // à la liste des observateurs
        // de l'objet observé
        lObserve.addObs(lConcreteObservateurA);
        lObserve.addObs(lConcreteObservateurB);
        
        // Fixe l'objet observé des observateurs
        lConcreteObservateurA.setObserve(lObserve);
        lConcreteObservateurB.setObserve(lObserve);
        
        // Affiche l'état des deux observateurs
        lConcreteObservateurA.afficher();
        lConcreteObservateurB.afficher();
        
        // Appel d'un méthode de mise à jour
        // de l'objet observé
        lObserve.setValeur(4);
        
        // Affiche l'état des deux observateurs
        lConcreteObservateurA.afficher();
        lConcreteObservateurB.afficher();
        
        // Affichage :
        // ConcreteObservateurA contient 0
        // ConcreteObservateurB contient 0
        // ConcreteObservateurA contient 4
        // ConcreteObservateurB contient 4
    }
}
