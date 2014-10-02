package epic.actions;

import epic.characters.Person;


/**
 * @author Bruno
 * 
 * Inherit from Act 
 * the two properties:
 * Character who 
 * DecimalFormat df
 * 
 * Implement write()
 * by writing on the console
 * */
 
public class Speak extends Act{
	
	Person to;
	String text;
	
	
	/**
	 * Constructor of a speak:
	 * 'who' say to 'to' a 'text'
	 * @param who
	 * @param to
	 * @param text
	 */
	public Speak(Person who, Person to, String text){
		this.who=who;
		this.to=to;
		this.text=text;
	}
		
	/* (non-Javadoc)
	 * @see epic.actions.Act#write()
	 */
	public String write(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.df.format(++Counter.counter));
		sb.append(" - ");
		sb.append(this.who.getName());
		sb.append(" says");
		if(to!=null){
			sb.append(" to ");
			sb.append(this.to.getName());
		}
		sb.append(": \"");
		sb.append(text);
		sb.append("\".");
		return sb.toString();
	}

}
