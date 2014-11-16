package designpattern.creational.abstractfactory;

/**
 * D�finit l'interface de la m�thode de Creation.
 */
public interface AbstractFactory {
    
    /**
     * M�thode de Creation d'un objet de classe AbstractClasse.
     * @return L'objet cr��.
     */
    public AbstractClass createClass();
}