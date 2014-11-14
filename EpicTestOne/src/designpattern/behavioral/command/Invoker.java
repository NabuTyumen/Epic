package designpattern.behavioral.command;

/**
 * Déclenche les commands.
 */
public class Invoker {

    // Reference through commands
    private Command commandA;
    private Command commandB;
    
    // Méthods to invoke commands
    public void invokeA() {
        if(commandA != null) {
            commandA.execute();
        }
    }
    
    public void invokeB() {
        if(commandB != null) {
        	commandB.execute();
        }
    }
    
    // Methode to set the command
    public void setCommandA(Command pCommandA) {
        commandA = pCommandA;
    }
    
    public void setCommandB(Command pCommandB) {
        commandB = pCommandB;
    }
}
