package gof.behavioral.command;

public class ConcreteCommandB implements Command {

	 private Receptor receptor;
	    
	    public ConcreteCommandB(Receptor pRecepteur) {
	        receptor = pRecepteur;
	    }
	    
	    public void execute() {
	        receptor.action2();
	    }

}
