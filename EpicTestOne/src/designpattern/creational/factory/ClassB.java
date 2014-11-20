package designpattern.creational.factory;


/**
 * Sous-class of AbstractClasse.
 */
public class ClassB implements AbstractClasse {

    /**
     * Implementation of the method displayClass.
     * Show that is a object of ClassB
     */
    public void displayClass() {
        System.out.println(ClassB.class.toString());
    }
}
