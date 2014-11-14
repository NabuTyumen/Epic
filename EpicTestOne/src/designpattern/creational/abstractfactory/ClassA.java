package designpattern.creational.abstractfactory;

/**
 * Sous classe de AbstractClasse
 * Cette classe est instanciée par ConcreteFabriqueA
 */
public class ClassA implements AbstractClass {
    
    /**
     * Implémentation de la méthode d'affichage
     */
    public void displayClass() {
        System.out.println(ClassA.class.toString());
    }
}