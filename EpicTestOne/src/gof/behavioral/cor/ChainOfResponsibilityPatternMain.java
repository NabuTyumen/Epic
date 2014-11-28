package gof.behavioral.cor;

public class ChainOfResponsibilityPatternMain {

	public static void main(String[] args) {
		 // Creation of the link
        Link lLinkA = new LinkA();
        Link lLinkB = new LinkB();
        Link lLinkC = new LinkC();
        
        //Sequence of link
        lLinkA.setNext(lLinkB);
        lLinkB.setNext(lLinkC);
        
        // Call first link method
        // with different values
        System.out.println("--> Call method with parameter '1' : ");
        lLinkA.operation(1);
        System.out.println("--> Call method with parameter  '2' : ");
        lLinkA.operation(2);
        System.out.println("--> Call method with parameter  '3' : ");
        lLinkA.operation(3);
        System.out.println("--> Call method with parameter  '4' : ");
        lLinkA.operation(4);
        
        // Displayed : 
      //--> Call method with parameter '1' : 
      //LinkB : 1 : < 2
      //--> Call method with parameter  '2' : 
      //LinkA : 2 : even
      //--> Call method with parameter  '3' : 
      //LinkC : 3 : > 2
      //--> Call method with parameter  '4' : 
      //LinkA : 4 : even

	}

}
