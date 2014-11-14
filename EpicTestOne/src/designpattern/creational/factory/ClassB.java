package designpattern.creational.factory;

import designpattern.creational.abstractfactory.ClassA;

/**
 * Sous-class de AbstractClasse.
 */
public class ClassB implements AbstractClasse {

    /**
     * Implémentation de la méthode d'affichage.
     * Indique qu'il s'agit d'un objet de classe ClasseB
     */
    public void displayClass() {
        System.out.println(ClassB.class.toString());
    }
}
