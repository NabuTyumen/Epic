package designpattern.creational.factory;


/**
 * Sous-class de AbstractClasse.
 */
public class ClassA implements AbstractClasse {

    /**
     * Implémentation de la méthode d'affichage.
     * Indique qu'il s'agit d'un objet de classe ClasseA
     */
    public void displayClass() {
        System.out.println(ClassA.class.toString());
    }
}
