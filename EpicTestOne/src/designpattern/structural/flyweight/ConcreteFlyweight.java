package designpattern.structural.flyweight;

/**
 * Class about which we wish to limit the number of instances in memory
 */
public class ConcreteFlyweight implements Flyweight {

    private String value;
    
    public ConcreteFlyweight(String pvalue) {
        value = pvalue;
    }

    public void display(String pContexte) {
        System.out.println("Flyweight with value: " + value + 
        		" and context: " +pContexte);
    }
}