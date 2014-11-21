package gof.structural.flyweight;

/**
 * Sub-class of Flyweight wth no shared instance.
 */
public class ConcreteFlyweightNonShared implements Flyweight {

    private String value1;
    private String value2;
    
    public ConcreteFlyweightNonShared(String pvalue1, String pvalue2) {
        value1 = pvalue1;
        value2 = pvalue2;
    }
    
    public void display(String pContexte) {
        System.out.println("Flyweight with value1 : " + value1 +
                " with value2 : " + value2);
    }
}