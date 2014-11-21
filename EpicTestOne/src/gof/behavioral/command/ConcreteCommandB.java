package gof.behavioral.command;

public class ConcreteCommandB implements Command {

	 private Receptor recepteur;
	    
	    public ConcreteCommandB(Receptor pRecepteur) {
	        recepteur = pRecepteur;
	    }
	    
	    public void execute() {
	        recepteur.action2();
	    }

}
