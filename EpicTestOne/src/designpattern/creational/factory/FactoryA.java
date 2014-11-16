package designpattern.creational.factory;

/**
 * Substitue la m�thode "creerClasse".
 * Instancie un objet "ClasseA".
 */
public class FactoryA extends Factory {

    /**
     * M�thode de Creation
     * La m�thode retourne un objet ClasseA, si le param�tre est true.
     * La m�thode retourne un objet ClasseB, sinon.
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
