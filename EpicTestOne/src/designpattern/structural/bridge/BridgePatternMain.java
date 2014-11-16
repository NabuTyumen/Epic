package designpattern.structural.bridge;

public class BridgePatternMain {

    public static void main(String[] args) {
        // Creation des implémentations
        Implementation lImplementationA = new ImplementationA();
        Implementation lImplementationB = new ImplementationB();
        
        // Creation des abstractions
        Abstraction lAbstractionAA = new AbstractionA(lImplementationA);
        Abstraction lAbstractionAB = new AbstractionA(lImplementationB);
        Abstraction lAbstractionBA = new AbstractionB(lImplementationA);
        Abstraction lAbstractionBB = new AbstractionB(lImplementationB);
        
        // Appels des méthodes des abstractions
        lAbstractionAA.operation();
        lAbstractionAB.operation();
        lAbstractionBA.operation();
        lAbstractionBB.operation();
        
        // Affichage : 
        // --> Méthode operation() de AbstractionA
        // operationImpl1 de ImplementationA : A
        // operationImpl2 de ImplementationA : 1
        // operationImpl1 de ImplementationA : B
        // --> Méthode operation() de AbstractionA
        // operationImpl1 de ImplementationB : A
        // operationImpl2 de ImplementationB : 1
        // operationImpl1 de ImplementationB : B
        // --> Méthode operation() de AbstractionB
        // operationImpl2 de ImplementationA : 9
        // operationImpl2 de ImplementationA : 8
        // operationImpl1 de ImplementationA : Z
        // --> Méthode operation() de AbstractionB
        // operationImpl2 de ImplementationB : 9
        // operationImpl2 de ImplementationB : 8
        // operationImpl1 de ImplementationB : Z
    }
}
