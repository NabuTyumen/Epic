package gof.structural.adapter;

/**
 * Implement interface "Standard".
 */
public class ImplStandard implements Standard {

    public void operation(int pNombre1, int pNombre2) {
        System.out.println("Standard : Number is : " + (pNombre1 * pNombre2));
    }
}
