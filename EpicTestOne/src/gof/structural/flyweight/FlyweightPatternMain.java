package gof.structural.flyweight;

public class FlyweightPatternMain {

    public static void main(String[] args) {
        // Instantiate factory, that create and store some Flyweights : "Alpha", "Bravo", "Charlie", "Echo"
        FlyweightFactory lFlyweightFactory = new FlyweightFactory();
        
        // Get "Flyweight" which are shared
        Flyweight lFlyweight1 = lFlyweightFactory.getFlyweight("Alpha");
        Flyweight lFlyweight1Bis = lFlyweightFactory.getFlyweight("Bravo");

        // Display this two "Flyweight"
        lFlyweight1.display("Context1");
        lFlyweight1Bis.display("Context1Bis");

        // Display if the reference point to the same instance
        // This is logical since it is the principle of shared instance.
        System.out.print("lFlyweight1 == lFlyweight1Bis : ");
        System.out.println(lFlyweight1 == lFlyweight1Bis);

        // Get "Flyweight" which are not part of the existing
        Flyweight lFlyweight2 = lFlyweightFactory.getFlyweight("Golf");
        Flyweight lFlyweight2Bis = lFlyweightFactory.getFlyweight("Hotel");

        // Display this two "Flyweight"
        lFlyweight2.display("Context2");
        lFlyweight2Bis.display("Context2Bis");
        
        // Get and display a non shared "Flyweight" 
        Flyweight lFlyweight3 = lFlyweightFactory.getFlyweight("Black", "Blue");
        lFlyweight3.display(null);
                
        // Displayed : 
      //--> Return a shared Flyweight (Alpha) that still exist
      //--> Return a shared Flyweight (Bravo) that still exist
      //Flyweight with value: Alpha and context: Context1
      //Flyweight with value: Bravo and context: Context1Bis
      //lFlyweight1 == lFlyweight1Bis : false
      //--> Return a shared Flyweight (Golf) that still not exist
      //--> Return a shared Flyweight (Hotel) that still not exist
      //Flyweight with value: Golf and context: Context2
      //Flyweight with value: Hotel and context: Context2Bis
      //--> Return a non shared Flyweight (Black, Blue)
      //Flyweight with value1 : Black with value2 : Blue 

    }
}