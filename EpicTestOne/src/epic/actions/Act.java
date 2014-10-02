package epic.actions;

import java.text.DecimalFormat;

import epic.characters.Person;

public abstract class Act {
	
	public Person who;
	protected final DecimalFormat df = new DecimalFormat("00");
	
	public abstract String write();

}
