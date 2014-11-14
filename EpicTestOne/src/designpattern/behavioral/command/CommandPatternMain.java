package designpattern.behavioral.command;

public class CommandPatternMain {

    public static void main(String[] args) {
        // Creation of a receptor
        Receptor lReceptor = new Receptor();
        
        // Creation of commands
        Command lCommandA = new ConcreteCommandA(lReceptor);
        Command lCommandB = new ConcreteCommandB(lReceptor);

        // Creation and initialisation of invoker
        Invoker lInvoqueur = new Invoker();
        lInvoqueur.setCommandA(lCommandA);
        lInvoqueur.setCommandB(lCommandB);
        
        // Call invocation method
        // NB : This class represents the client part. 
        //So normally the invocation does not happen in the client portion 
        //In the example, it is here for brevity
        lInvoqueur.invokeA();
        lInvoqueur.invokeB();
        
        // Affichage :
        // Traitement numero 1 effectué.
        // Traitement numero 2 effectué.
    }
}