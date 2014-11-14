package designpattern.behavioral.iterator;

/**
 * D�finit l'interface de l'it�rateur.
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