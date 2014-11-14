package designpattern.behavioral.cor;

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
        
        // Affichage : 
        // --> Appel de la méthode avec paramètre '1' : 
        // LinkB : 1 : < 2
        // --> Appel de la méthode avec paramètre '2' : 
        // LinkA : 2 : pair
        // --> Appel de la méthode avec paramètre '3' : 
        // LinkC : 3 : > 2
        // --> Appel de la méthode avec paramètre '4' : 
        // LinkA : 4 : pair

	}

}
