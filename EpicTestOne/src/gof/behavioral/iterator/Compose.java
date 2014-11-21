package gof.behavioral.iterator;

/**
 * Define l'interface d'un object compos�.
 */
public interface Compose {

    /**
     * Return un object "Iterator"
     */
    public Iterator createIterator();
}