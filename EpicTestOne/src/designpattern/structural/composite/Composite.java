package designpattern.structural.composite;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implement un object de l'arborescence 
 * ayant un ou des objects le composant.
 */
public class Composite extends Component {

    // list d'objects "Composant" of the object "Composite"
    private List<Component> list = new LinkedList<Component>();
    
    public Composite(final String pNom) {
        super(pNom);
    }
    
    /**
     * Method commune à tous les composants :
     * Display qu'il s'agit d'un object "Composite"
     * ainsi que le nom qu'on lui a donné, 
     * puis appelle la method "operation()" 
     * de tous les composants de cet object. 
     */
    public void operation() {
        System.out.println("Op. sur un 'Composite' (" + name + ")");
        final Iterator<Component> lIterator = list.iterator();
        while(lIterator.hasNext()) {
            final Component lComposant = lIterator.next();
            lComposant.operation();
        }
    }

    /**
     * Return la list d'objects "Composant"
     * @return La list d'objects "Composant"
     */
    public List<Component> getEnfants() {
        return list;
    }
    
    /**
     * Ajoute un object "Composant" au "Composite"
     * @param pComposant
     */
    public void add(final Component pComposant) {
        list.add(pComposant);
    }
    
    /**
     * Retire un object "Composant"
     * @param pComposant
     */
    public void retirer(final Component pComposant) {
        list.remove(pComposant);
    }
}
