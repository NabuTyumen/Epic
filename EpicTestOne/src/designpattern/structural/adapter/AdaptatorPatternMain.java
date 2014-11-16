package designpattern.structural.adapter;

public class AdaptatorPatternMain {

    public static void main(String[] args) {
        // Creation d'un adaptateur
        final Standard lImplAdapte = new Adaptateur();
        // Creation d'une implémentation standard
        final Standard lImplStandard = new ImplStandard();

        // Appel de la même méthode sur chaque instance
        lImplAdapte.operation(2, 4);
        lImplStandard.operation(2, 4);
        
        // Affichage : 
        // Adapte : Le nombre est : 8
        // Standard : Le nombre est : 8
    }
}
