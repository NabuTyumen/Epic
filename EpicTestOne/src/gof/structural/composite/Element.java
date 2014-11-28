package gof.structural.composite;

/**
 * Implement a object of the tree
 * without Component.
 */
public class Element extends Component {

    public Element(final String pNom) {
        super(pNom);
    }

    /**
     * Common method of all Component:
     * Display if it is a "Element"
     * with the name given.
     */
    public void operation() {
        System.out.println("Operation on a 'Element' (" + name + ")");
    }
}
