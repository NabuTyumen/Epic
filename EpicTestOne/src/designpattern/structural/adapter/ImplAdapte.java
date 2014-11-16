package designpattern.structural.adapter;

/**
 * Fournit les fonctionnalités définies dans l'interface "Standard",
 * mais ne respecte pas l'interface.
 */
public class ImplAdapte {

    public int operationAdapte1(int pNombre1, int pNombre2) {
        return pNombre1 * pNombre2;
    }
    
    /**
     * Apporte la fonctionalité définie dans l'interface,
     * mais la méthode n'a pas le bon nom 
     * et n'accepte pas le même paramètre.
     */
    public void operationAdapte2(int pNombre) {
        System.out.println("Adapte : Le nombre est : " + pNombre);
    }
}