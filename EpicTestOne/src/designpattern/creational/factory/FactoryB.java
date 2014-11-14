package designpattern.creational.factory;

/**
 * Substitue la m�thode "creerClasse".
 * Instancie un objet "ClasseB".
 */
public class FactoryB extends Factory {

    /**
     * M�thode de cr�ation
     * La m�thode ne tient pas compte du param�tre
     * et instancie toujours un objet "ClasseB"
     * @return Un objet de classe ClasseB.
     */
    public AbstractClasse createClass(boolean pIsClasseA) {
        return new ClassB();
    }
}
