package designpattern.structural.composite;

/**
 * Impl�mente un objet de l'arborescence 
 * n'ayant pas d'objet le composant.
 */
public class Element extends Composant {

    public Element(final String pNom) {
        super(pNom);
    }

    /**
     * M�thode commune � tous les composants :
     * Affiche qu'il s'agit d'un objet "Element"
     * ainsi que le nom qu'on lui a donn�.
     */
    public void operation() {
        System.out.println("Op. sur un 'Element' (" + nom + ")");
    }
}
