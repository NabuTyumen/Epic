package designpattern.structural.adapter;

/**
 * Fournit les fonctionnalit�s d�finies dans l'interface "Standard",
 * mais ne respecte pas l'interface.
 */
public class ImplAdapte {

    public int operationAdapte1(int pNombre1, int pNombre2) {
        return pNombre1 * pNombre2;
    }
    
    /**
     * Apporte la fonctionalit� d�finie dans l'interface,
     * mais la m�thode n'a pas le bon nom 
     * et n'accepte pas le m�me param�tre.
     */
    public void operationAdapte2(int pNombre) {
        System.out.println("Adapte : Le nombre est : " + pNombre);
    }
}