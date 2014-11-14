package designpattern.behavioral.iterator;

/**
 * D�finit l'interface d'un objet compos�.
 */
public interface Compose {

    /**
     * Retourne un objet "Iterateur"
     */
    public Iterateur createIterateur();
}