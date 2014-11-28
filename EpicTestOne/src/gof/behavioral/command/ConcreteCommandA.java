package gof.behavioral.command;

public class ConcreteCommandA implements Command {

	 private Receptor receptor;
	    
	    public ConcreteCommandA(Receptor pRecepteur) {
	        receptor = pRecepteur;
	    }
	    
	    public void execute() {
	        receptor.action1();
	    }

}
