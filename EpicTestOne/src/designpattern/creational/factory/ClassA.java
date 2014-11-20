package designpattern.creational.factory;


/**
 * Sub-class of AbstractClasse.
 */
public class ClassA implements AbstractClasse {

    /**
     * Implementation of the method displayClass.
     * Show that is a object of ClassA
     */
    public void displayClass() {
        System.out.println(ClassA.class.toString());
    }
}
