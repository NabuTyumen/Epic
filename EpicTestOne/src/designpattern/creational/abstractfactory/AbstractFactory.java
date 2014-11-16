package designpattern.creational.abstractfactory;

/**
 * Définit l'interface de la méthode de Creation.
 */
public interface AbstractFactory {
    
    /**
     * Méthode de Creation d'un objet de classe AbstractClasse.
     * @return L'objet créé.
     */
    public AbstractClass createClass();
}