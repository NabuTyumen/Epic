package designpattern.structural.composite;

/**
 * Implémente un objet de l'arborescence 
 * n'ayant pas d'objet le composant.
 */
public class Element extends Composant {

    public Element(final String pNom) {
        super(pNom);
    }

    /**
     * Méthode commune à tous les composants :
     * Affiche qu'il s'agit d'un objet "Element"
     * ainsi que le nom qu'on lui a donné.
     */
    public void operation() {
        System.out.println("Op. sur un 'Element' (" + nom + ")");
    }
}
