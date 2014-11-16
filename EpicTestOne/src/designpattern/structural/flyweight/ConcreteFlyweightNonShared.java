package designpattern.structural.flyweight;

/**
 * Sous-classe de Poids-Mouche dont on ne partage pas les instances.
 */
public class ConcreteFlyweightNonShared implements Flyweight {

    private String value1;
    private String value2;
    
    public ConcreteFlyweightNonShared(String pvalue1, String pvalue2) {
        value1 = pvalue1;
        value2 = pvalue2;
    }
    
    public void display(String pContexte) {
        System.out.println("PoidsMouche avec la value1 : " + value1 +
                " avec la value2 : " + value2);
    }
}