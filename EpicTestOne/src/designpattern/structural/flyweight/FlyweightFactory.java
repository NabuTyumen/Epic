package designpattern.structural.flyweight;

import java.util.Hashtable;

/**
 * Flyweight factory
 */
public class FlyweightFactory {

    // Map of shared Flyweight
    private Hashtable<String, ConcreteFlyweight> flyweightShared = 
        new Hashtable<String, ConcreteFlyweight>();
    
    FlyweightFactory() {
        flyweightShared.put("Alpha", new ConcreteFlyweight("Alpha"));
        flyweightShared.put("Bravo", new ConcreteFlyweight("Bravo"));
        flyweightShared.put("Charlie", new ConcreteFlyweight("Charlie"));
        flyweightShared.put("Echo", new ConcreteFlyweight("Echo"));
     
    }
    
    /**
     * Return a shared "Flyweight" 
     * If the value given as parameter
     * matches with a shared "Flyweigt" that still exist
     * return it
     * If not, create a new instance
     * store it in the map 
     * an return it
     * @param pvalue value of required "Flyweight" 
     * @return a "Flyweight"
     */
    public Flyweight getFlyweight(String pvalue) {
        if(flyweightShared.containsKey(pvalue)) {
            System.out.println("--> Return a shared Flyweight (" + pvalue + 
                    ") that still exist");
            return flyweightShared.get(pvalue);
        }
        else {
            System.out.println("--> Return a shared Flyweight (" + pvalue + 
                    ") that still not exist");
            final ConcreteFlyweight lnewFlyweight = new ConcreteFlyweight(pvalue);
            flyweightShared.put(pvalue, lnewFlyweight);
            return lnewFlyweight;
        }
    }
    
    /**
     * Return a non shared "Flyweight" .
     * @param pvalue1
     * @param pvalue2
     * @return "Flyweight"
     */
    public Flyweight getFlyweight(String pvalue1, String pvalue2) {
        System.out.println("--> Return a non shared Flyweight (" + pvalue1 + ", " + 
                pvalue2 + ")");
        return new ConcreteFlyweightNonShared(pvalue1, pvalue2);
    }
}