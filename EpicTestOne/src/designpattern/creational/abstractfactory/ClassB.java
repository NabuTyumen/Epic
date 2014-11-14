package designpattern.creational.abstractfactory;

/**
 * Sous classe de AbstractClasse
 * Cette classe est instanciée par ConcreteFabriqueB
 */
public class ClassB implements AbstractClass {
    
    /**
     * Implémentation de la méthode d'affichage
     */
    public void displayClass() {
        System.out.println(ClassB.class.toString());
    }
}
