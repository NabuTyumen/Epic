package designpattern.structural.composite;

public class CompositePatternMain {

    public static void main(String[] args) {
        
        // On va créer l'arborescence :
        // lComposite1 
        //        - lElement1
        //        - lComposite2
        //                - lComposite3
        //                        - lElement3
        //                        - lElement4
        //                - lComposite4
        //                        - lComposite5
        //                                - lElement5
        //        - lElement2
        
        // Creation des objets "Composite"
        final Composite lComposite1 = new Composite("Composite 1");
        final Composite lComposite2 = new Composite("Composite 2");
        final Composite lComposite3 = new Composite("Composite 3");
        final Composite lComposite4 = new Composite("Composite 4");
        final Composite lComposite5 = new Composite("Composite 5");
        
        // Creation des objets "Element"
        final Element lElement1 = new Element("Element 1");
        final Element lElement2 = new Element("Element 2");
        final Element lElement3 = new Element("Element 3");
        final Element lElement4 = new Element("Element 4");
        final Element lElement5 = new Element("Element 5");
    
        // Ajout des "Composant" afin de constituer l'arborescence
        lComposite1.ajouter(lElement1);
        lComposite1.ajouter(lComposite2);
        lComposite1.ajouter(lElement2);
        
        lComposite2.ajouter(lComposite3);
        lComposite2.ajouter(lComposite4);
        
        lComposite3.ajouter(lElement3);
        lComposite3.ajouter(lElement4);
        
        lComposite4.ajouter(lComposite5);
        
        lComposite5.ajouter(lElement5);
        
        // Appel de la méthode "operation()" de la racine
        // afin d'display les différents "Composant"
        lComposite1.operation();

        // Affichage :
        // Op. sur un 'Composite' (Composite 1)
        // Op. sur un 'Element' (Element 1)
        // Op. sur un 'Composite' (Composite 2)
        // Op. sur un 'Composite' (Composite 3)
        // Op. sur un 'Element' (Element 3)
        // Op. sur un 'Element' (Element 4)
        // Op. sur un 'Composite' (Composite 4)
        // Op. sur un 'Composite' (Composite 5)
        // Op. sur un 'Element' (Element 5)
        // Op. sur un 'Element' (Element 2)
    }
}