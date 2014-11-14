package designpattern.creational.factory;

/**
 * Substitue la méthode "creerClasse".
 * Instancie un objet "ClasseB".
 */
public class FactoryB extends Factory {

    /**
     * Méthode de création
     * La méthode ne tient pas compte du paramètre
     * et instancie toujours un objet "ClasseB"
     * @return Un objet de classe ClasseB.
     */
    public AbstractClasse createClass(boolean pIsClasseA) {
        return new ClassB();
    }
}
