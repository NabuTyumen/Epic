package gof.behavioral.command;

/**
 * Trigger commands.
 */
public class Invoker {

    // Reference through commands
    private Command commandA;
    private Command commandB;
    
    // Methods to invoke commands
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
    
    // Method to set the command
    public void setCommandA(Command pCommandA) {
        commandA = pCommandA;
    }
    
    public void setCommandB(Command pCommandB) {
        commandB = pCommandB;
    }
}
