package designpattern.structural.flyweight;

/**
 * Class dont on souhaite limiter le nombre d'instance en mémoire.
 */
public class ConcreteFlyweight implements Flyweight {

    private String value;
    
    public ConcreteFlyweight(String pvalue) {
        value = pvalue;
    }

    public void display(String pContexte) {
        System.out.println("PoidsMouche avec la value : " + value + 
        		" et contexte : " +pContexte);
    }
}