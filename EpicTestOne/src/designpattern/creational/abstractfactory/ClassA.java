package designpattern.creational.abstractfactory;

/**
 * Sous classe de AbstractClasse
 * Cette classe est instanci�e par ConcreteFabriqueA
 */
public class ClassA implements AbstractClass {
    
    /**
     * Impl�mentation de la m�thode d'affichage
     */
    public void displayClass() {
        System.out.println(ClassA.class.toString());
    }
}