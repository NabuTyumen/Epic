package gof.structural.composite;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implement a object of the tree
 */
public class Composite extends Component {

    // list objects "Composite" of the object "Composite"
    private List<Component> list = new LinkedList<Component>();
    
    public Composite(final String pNom) {
        super(pNom);
    }
    
    /**
     * Common method of all component :
     * Display that it is a "Composite"
     * and the given name, 
     * then call method "operation()" 
     * of all the component of the object. 
     */
    public void operation() {
        System.out.println("Operation on a 'Composite' (" + name + ")");
        final Iterator<Component> lIterator = list.iterator();
        while(lIterator.hasNext()) {
            final Component lComposant = lIterator.next();
            lComposant.operation();
        }
    }

    /**
     * Return objects list "Composite"
     * @return 
     */
    public List<Component> getChilds() {
        return list;
    }
    
    /**
     * Add a object "Component" to the "Composite"
     * @param pComposant
     */
    public void add(final Component pComposant) {
        list.add(pComposant);
    }
    
    /**
     * Remove a object "Component"
     * @param pComposant
     */
    public void remove(final Component pComposant) {
        list.remove(pComposant);
    }
}
