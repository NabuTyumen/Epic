package designpattern.creational.abstractfactory;

/**
 * Définit l'interface de la méthode de création.
 */
public interface AbstractFactory {
    
    /**
     * Méthode de création d'un objet de classe AbstractClasse.
     * @return L'objet créé.
     */
    public AbstractClass createClass();
}