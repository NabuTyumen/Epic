package designpattern.creational.factory;


/**
 * Sous-class de AbstractClasse.
 */
public class ClassA implements AbstractClasse {

    /**
     * Impl�mentation de la m�thode d'affichage.
     * Indique qu'il s'agit d'un objet de classe ClasseA
     */
    public void displayClass() {
        System.out.println(ClassA.class.toString());
    }
}
