package designpattern.structural.bridge;

public class BridgePatternMain {

    public static void main(String[] args) {
        // Creation des impl�mentations
        Implementation lImplementationA = new ImplementationA();
        Implementation lImplementationB = new ImplementationB();
        
        // Creation des abstractions
        Abstraction lAbstractionAA = new AbstractionA(lImplementationA);
        Abstraction lAbstractionAB = new AbstractionA(lImplementationB);
        Abstraction lAbstractionBA = new AbstractionB(lImplementationA);
        Abstraction lAbstractionBB = new AbstractionB(lImplementationB);
        
        // Appels des m�thodes des abstractions
        lAbstractionAA.operation();
        lAbstractionAB.operation();
        lAbstractionBA.operation();
        lAbstractionBB.operation();
        
        // Affichage : 
        // --> M�thode operation() de AbstractionA
        // operationImpl1 de ImplementationA : A
        // operationImpl2 de ImplementationA : 1
        // operationImpl1 de ImplementationA : B
        // --> M�thode operation() de AbstractionA
        // operationImpl1 de ImplementationB : A
        // operationImpl2 de ImplementationB : 1
        // operationImpl1 de ImplementationB : B
        // --> M�thode operation() de AbstractionB
        // operationImpl2 de ImplementationA : 9
        // operationImpl2 de ImplementationA : 8
        // operationImpl1 de ImplementationA : Z
        // --> M�thode operation() de AbstractionB
        // operationImpl2 de ImplementationB : 9
        // operationImpl2 de ImplementationB : 8
        // operationImpl1 de ImplementationB : Z
    }
}
