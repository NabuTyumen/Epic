package designpattern.creational.abstractfactory;

/**
 * D�finit l'interface de la m�thode de cr�ation.
 */
public interface AbstractFactory {
    
    /**
     * M�thode de cr�ation d'un objet de classe AbstractClasse.
     * @return L'objet cr��.
     */
    public AbstractClass createClass();
}