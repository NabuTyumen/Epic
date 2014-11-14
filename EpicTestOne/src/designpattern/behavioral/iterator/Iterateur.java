package designpattern.behavioral.iterator;

/**
 * Définit l'interface de l'itérateur.
 */
public interface Iterateur {

    /**
     * return next element
     */
    public String next();
    
    /**
     * return true if iterateur
     * come to the last element
     */
    public boolean end();
}