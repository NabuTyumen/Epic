package designpattern.structural.adapter;

public class AdaptatorPatternMain {

    public static void main(String[] args) {
        // Creation of a adapter
        final Standard lImplAdapte = new Adapter();
        // Creation of a standard implementation
        final Standard lImplStandard = new ImplStandard();

        // Appel de la m�me method sur chaque instance
        lImplAdapte.operation(2, 4);
        lImplStandard.operation(2, 4);
        
        // Displayed : 
        // Adapte : Le nombre est : 8
        // Standard : Le nombre est : 8
    }
}
