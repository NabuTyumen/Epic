package designpattern.structural.adapter;

/**
 * D�finit une interface qui est identifi�e 
 * comme standard dans la partie cliente. 
 */
public interface Standard {

    /**
     * L'op�ration doit multiplier les deux nombres,
     * puis display le r�sultat de l'op�ration
     */
    public void operation(int pNombre1, int pNombre2);
}

