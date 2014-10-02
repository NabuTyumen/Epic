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
	public void write(){
		System.out.println();
		System.out.print(" ver. ");
		System.out.print(super.df.format(++Counter.counter));
		System.out.print(" - ");
		System.out.print(this.who.getName());
		System.out.print(" says");
		if(to!=null){
			System.out.print(" to ");
			System.out.print(this.to.getName());
		}
		System.out.print(": \"");
		System.out.print(text);
		System.out.print("\".");
	}

}
