package designpattern.structural.adapter;

/**
 * Implémente l'interface "Standard".
 */
public class ImplStandard implements Standard {

    public void operation(int pNombre1, int pNombre2) {
        System.out.println("Standard : Le nombre est : " + (pNombre1 * pNombre2));
    }
}
