package designpattern.behavioral.iterator;

/**
 * Définit l'interface d'un objet composé.
 */
public interface Compose {

    /**
     * Retourne un objet "Iterateur"
     */
    public Iterateur createIterateur();
}