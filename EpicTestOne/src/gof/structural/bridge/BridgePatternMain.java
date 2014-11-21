package gof.structural.bridge;

public class BridgePatternMain {

    public static void main(String[] args) {
        // Creation of the implementations
        Implementation lImplementationA = new ImplementationA();
        Implementation lImplementationB = new ImplementationB();
        
        // Creation of the abstractions
        Abstraction lAbstractionAA = new AbstractionA(lImplementationA);
        Abstraction lAbstractionAB = new AbstractionA(lImplementationB);
        Abstraction lAbstractionBA = new AbstractionB(lImplementationA);
        Abstraction lAbstractionBB = new AbstractionB(lImplementationB);
        
        // Call methods of abstractions
        lAbstractionAA.operation();
        lAbstractionAB.operation();
        lAbstractionBA.operation();
        lAbstractionBB.operation();
        
        // Displayed : 
        //--> Method operation() of AbstractionA
        //operationImpl1 of ImplementationA : A
        //operationImpl2 of ImplementationA : 1
        //operationImpl1 of ImplementationA : B
        //--> Method operation() of AbstractionA
        //operationImpl1 of ImplementationB : A
        //operationImpl2 of ImplementationB : 1
        //operationImpl1 of ImplementationB : B
        //--> Method operation() of AbstractionB
        //operationImpl2 of ImplementationA : 9
        //operationImpl2 of ImplementationA : 8
        //operationImpl1 of ImplementationA : Z
        //--> Method operation() of AbstractionB
        //operationImpl2 of ImplementationB : 9
        //operationImpl2 of ImplementationB : 8
        //operationImpl1 of ImplementationB : Z
    }
}
