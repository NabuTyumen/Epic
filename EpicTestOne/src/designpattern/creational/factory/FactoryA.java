package designpattern.creational.factory;

/**
 * Substitue la méthode "creerClasse".
 * Instancie un objet "ClasseA".
 */
public class FactoryA extends Factory {

    /**
     * Méthode de Creation
     * La méthode retourne un objet ClasseA, si le paramètre est true.
     * La méthode retourne un objet ClasseB, sinon.
     * @return Un objet de classe ClasseA ou ClasseB.
     */
    public AbstractClasse createClass(boolean pIsClasseA) {
        if(pIsClasseA) {
            return new ClassA();
        }
        else {
            return new ClassB();
        }
    }
}
