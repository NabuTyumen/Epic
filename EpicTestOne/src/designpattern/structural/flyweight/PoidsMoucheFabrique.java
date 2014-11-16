package designpattern.structural.flyweight;

import java.util.Hashtable;

/**
 * Fabrique de PoidsMouche
 */
public class PoidsMoucheFabrique {

    // Tableau des "PoidsMouche" partag�s
    private Hashtable<String, ConcreteFlyweight> poidsMouchesPartages = 
        new Hashtable<String, ConcreteFlyweight>();
    
    PoidsMoucheFabrique() {
        poidsMouchesPartages.put("Bonjour", new ConcreteFlyweight("Bonjour"));
        poidsMouchesPartages.put("le", new ConcreteFlyweight("le"));
        poidsMouchesPartages.put("monde", new ConcreteFlyweight("monde"));
    }
    
    /**
     * Retourne un "PoidsMouche" partag�
     * Si la value pass� en param�tre 
     * correspond � un "PoidsMouche" partag� d�j� existant,
     * on le retourne. 
     * Sinon on cr�e une nouvelle instance,
     * on la stocke et on la retourne.
     * @param pvalue value du "PoidsMouche" d�sir�
     * @return un "PoidsMouche"
     */
    public Flyweight getPoidsMouche(String pvalue) {
        if(poidsMouchesPartages.containsKey(pvalue)) {
            System.out.println("--> Retourne un PoidsMouche (" + pvalue + 
                    ") partag� d�j� existant");
            return poidsMouchesPartages.get(pvalue);
        }
        else {
            System.out.println("--> Retourne un PoidsMouche (" + pvalue + 
                    ") partag� non d�j� existant");
            final ConcreteFlyweight lNouveauPoidsMouche = new ConcreteFlyweight(pvalue);
            poidsMouchesPartages.put(pvalue, lNouveauPoidsMouche);
            return lNouveauPoidsMouche;
        }
    }
    
    /**
     * Retourne un "PoidsMouche" non partag�.
     * @param pvalue1
     * @param pvalue2
     * @return un "PoidsMouche"
     */
    public Flyweight getPoidsMouche(String pvalue1, String pvalue2) {
        System.out.println("--> Retourne un PoidsMouche (" + pvalue1 + ", " + 
                pvalue2 + ") non partag�");
        return new ConcreteFlyweightNonShared(pvalue1, pvalue2);
    }
}