package designpattern.behavioral.iterator;

/**
 * Define l'interface de l'itérateur.
 */
public interface Iterator {

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