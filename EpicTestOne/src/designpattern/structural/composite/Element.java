package designpattern.structural.composite;

/**
 * Implement un object de l'arborescence 
 * n'ayant pas d'object le composant.
 */
public class Element extends Component {

    public Element(final String pNom) {
        super(pNom);
    }

    /**
     * Method commune à tous les composants :
     * Display qu'il s'agit d'un object "Element"
     * ainsi que le nom qu'on lui a donné.
     */
    public void operation() {
        System.out.println("Op. sur un 'Element' (" + name + ")");
    }
}
