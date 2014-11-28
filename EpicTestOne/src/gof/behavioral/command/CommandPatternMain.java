package gof.behavioral.command;

public class CommandPatternMain {

    public static void main(String[] args) {
        // Creation of a receptor
        Receptor lReceptor = new Receptor();
        
        // Creation of commands
        Command lCommandA = new ConcreteCommandA(lReceptor);
        Command lCommandB = new ConcreteCommandB(lReceptor);

        // Creation and initialization of invoker
        Invoker lInvoker = new Invoker();
        lInvoker.setCommandA(lCommandA);
        lInvoker.setCommandB(lCommandB);
        
        // Call invocation method
        // NB : This class represents the client part. 
        //So normally the invocation does not happen in the client portion 
        //In the example, it is here for brevity
        lInvoker.invokeA();
        lInvoker.invokeB();
        
        // Displayed :
        // Process number 1 done.
        // Process number 2 done.
    }
}