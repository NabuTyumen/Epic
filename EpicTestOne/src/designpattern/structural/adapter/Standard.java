package designpattern.structural.adapter;

/**
 * Définit une interface qui est identifiée 
 * comme standard dans la partie cliente. 
 */
public interface Standard {

    /**
     * L'opération doit multiplier les deux nombres,
     * puis display le résultat de l'opération
     */
    public void operation(int pNombre1, int pNombre2);
}

