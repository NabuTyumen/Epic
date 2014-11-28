package gof.behavioral.iterator;

/**
 * Define interface iterator.
 */
public interface Iterator {

    /**
     * return next element
     */
    public String next();
    
    /**
     * return true if iterator
     * come to the last element
     */
    public boolean end();
}