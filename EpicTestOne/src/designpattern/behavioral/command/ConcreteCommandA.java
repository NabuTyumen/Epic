package designpattern.behavioral.command;

public class ConcreteCommandA implements Command {

	 private Receptor recepteur;
	    
	    public ConcreteCommandA(Receptor pRecepteur) {
	        recepteur = pRecepteur;
	    }
	    
	    public void execute() {
	        recepteur.action1();
	    }

}
