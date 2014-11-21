package gof.structural.adapter;

/**
 * Fit the non standard implementation 
 * First option : WITH INHERITANCE.
 */
public class Adapter extends ImplAdapte implements Standard {
	/**
	 * Called a non-standard methods
	* from a method respecting the interface.
	* 1) Call the method performing the multiplication
	* 2) Call the method to display the result
	* The appropriate class is inherited, so we directly call the methods
	 */

    public void operation(int pNombre1, int pNombre2) {
        int lNombre = operationAdapte1(pNombre1, pNombre2);
        operationAdapte2(lNombre);
    }
}