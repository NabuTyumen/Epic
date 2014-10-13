package epic.actions;

import epic.characters.Person;


/**
 * @author Bruno
 * 
 * Inherit from Act 
 * the two properties:
 * Person who 
 * DecimalFormat df
 * 
 * Implement write()
 * by writing on the console
 * */
 
public class Speak extends Act{
	
	Person to;
	String speech;
	
	
	/**
	 * Constructor of Speak:
	 * 'who' say to 'to' a 'text'
	 * @param who (inherited from the abstract class Act)
	 * @param to
	 * @param speech
	 */
	public Speak(Person who, Person to, String speech){
		this.who=who;
		this.to=to;
		this.speech=speech;
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
		System.out.print(speech);
		System.out.print("\".");
	}

}
