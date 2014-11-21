package gof.behavioral.iterator;

/**
 * Define l'interface d'un object composé.
 */
public interface Compose {

    /**
     * Return un object "Iterator"
     */
    public Iterator createIterator();
}