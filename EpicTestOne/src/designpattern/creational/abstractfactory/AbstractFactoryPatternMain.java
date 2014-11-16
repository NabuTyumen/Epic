package designpattern.creational.abstractfactory;

public class AbstractFactoryPatternMain {

    public static void main(String[] args) {
        // Creation des fabriques
        AbstractFactory lFactory1 = new ConcreteFactoryA();
        AbstractFactory lFactory2 = new ConcreteFactoryB();
        
        // Creation de deux "AbstractClasse" à partir de chaque fabrique
        AbstractClass lClasse1 = lFactory1.createClass();
        AbstractClass lClasse2 = lFactory2.createClass();
        
        // Appel d'une méthode d'"AbstractClasse" qui affiche un message
        // Ce message permet de vérifier que chaque "AbstractClasse"
        // est en fait une classe différente
        lClasse1.displayClass();
        lClasse2.displayClass();
        
        // --------------------------
        // Affichage : 
        // Objet de classe 'ClasseA'
        // Objet de classe 'ClasseB'
    }
}
