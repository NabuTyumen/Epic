package designpattern.creational.factory;

import designpattern.creational.abstractfactory.ClassA;

/**
 * Sous-class de AbstractClasse.
 */
public class ClassB implements AbstractClasse {

    /**
     * Impl�mentation de la m�thode d'affichage.
     * Indique qu'il s'agit d'un objet de classe ClasseB
     */
    public void displayClass() {
        System.out.println(ClassB.class.toString());
    }
}
