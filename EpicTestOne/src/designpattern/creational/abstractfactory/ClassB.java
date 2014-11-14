package designpattern.creational.abstractfactory;

/**
 * Sous classe de AbstractClasse
 * Cette classe est instanci�e par ConcreteFabriqueB
 */
public class ClassB implements AbstractClass {
    
    /**
     * Impl�mentation de la m�thode d'affichage
     */
    public void displayClass() {
        System.out.println(ClassB.class.toString());
    }
}
