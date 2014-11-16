package designpattern.structural.flyweight;

import java.util.Hashtable;

/**
 * Fabrique de PoidsMouche
 */
public class PoidsMoucheFabrique {

    // Tableau des "PoidsMouche" partagés
    private Hashtable<String, ConcreteFlyweight> poidsMouchesPartages = 
        new Hashtable<String, ConcreteFlyweight>();
    
    PoidsMoucheFabrique() {
        poidsMouchesPartages.put("Bonjour", new ConcreteFlyweight("Bonjour"));
        poidsMouchesPartages.put("le", new ConcreteFlyweight("le"));
        poidsMouchesPartages.put("monde", new ConcreteFlyweight("monde"));
    }
    
    /**
     * Retourne un "PoidsMouche" partagé
     * Si la value passé en paramètre 
     * correspond à un "PoidsMouche" partagé déjà existant,
     * on le retourne. 
     * Sinon on crée une nouvelle instance,
     * on la stocke et on la retourne.
     * @param pvalue value du "PoidsMouche" désiré
     * @return un "PoidsMouche"
     */
    public Flyweight getPoidsMouche(String pvalue) {
        if(poidsMouchesPartages.containsKey(pvalue)) {
            System.out.println("--> Retourne un PoidsMouche (" + pvalue + 
                    ") partagé déjà existant");
            return poidsMouchesPartages.get(pvalue);
        }
        else {
            System.out.println("--> Retourne un PoidsMouche (" + pvalue + 
                    ") partagé non déjà existant");
            final ConcreteFlyweight lNouveauPoidsMouche = new ConcreteFlyweight(pvalue);
            poidsMouchesPartages.put(pvalue, lNouveauPoidsMouche);
            return lNouveauPoidsMouche;
        }
    }
    
    /**
     * Retourne un "PoidsMouche" non partagé.
     * @param pvalue1
     * @param pvalue2
     * @return un "PoidsMouche"
     */
    public Flyweight getPoidsMouche(String pvalue1, String pvalue2) {
        System.out.println("--> Retourne un PoidsMouche (" + pvalue1 + ", " + 
                pvalue2 + ") non partagé");
        return new ConcreteFlyweightNonShared(pvalue1, pvalue2);
    }
}