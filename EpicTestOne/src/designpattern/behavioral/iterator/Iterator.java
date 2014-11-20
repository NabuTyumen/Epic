package designpattern.behavioral.iterator;

/**
 * Define l'interface de l'it�rateur.
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