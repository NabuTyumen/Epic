package gof.structural.composite;

public class CompositePatternMain {

    public static void main(String[] args) {
        
        // We will create the following tree:
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
        
        // Creation of objects "Composite"
        final Composite lComposite1 = new Composite("Composite 1");
        final Composite lComposite2 = new Composite("Composite 2");
        final Composite lComposite3 = new Composite("Composite 3");
        final Composite lComposite4 = new Composite("Composite 4");
        final Composite lComposite5 = new Composite("Composite 5");
        
        // Creation of objects "Element"
        final Element lElement1 = new Element("Element 1");
        final Element lElement2 = new Element("Element 2");
        final Element lElement3 = new Element("Element 3");
        final Element lElement4 = new Element("Element 4");
        final Element lElement5 = new Element("Element 5");
    
        // Add "Composite" to build tree
        lComposite1.add(lElement1);
        lComposite1.add(lComposite2);
        lComposite1.add(lElement2);
        
        lComposite2.add(lComposite3);
        lComposite2.add(lComposite4);
        
        lComposite3.add(lElement3);
        lComposite3.add(lElement4);
        
        lComposite4.add(lComposite5);
        
        lComposite5.add(lElement5);
        
        // Call method "operation()" of the root
        // to display the different "Composite"
        lComposite1.operation();

        // Displayed :
      //Operation on a 'Composite' (Composite 1)
      //Operation on a 'Element' (Element 1)
      //Operation on a 'Composite' (Composite 2)
      //Operation on a 'Composite' (Composite 3)
      //Operation on a 'Element' (Element 3)
      //Operation on a 'Element' (Element 4)
      //Operation on a 'Composite' (Composite 4)
      //Operation on a 'Composite' (Composite 5)
      //Operation on a 'Element' (Element 5)
      //Operation on a 'Element' (Element 2)
      //
    }
}