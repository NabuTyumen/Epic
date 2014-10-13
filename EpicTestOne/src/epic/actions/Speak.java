package epic.actions;

import java.text.DecimalFormat;

import epic.characters.Person;


 
public class Speak {
	Person who;
	Person to;
	String text;
	
	protected final DecimalFormat df = new DecimalFormat("00");
	
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
		
	public void write(){
		System.out.println();
		System.out.print(" ver. ");
		System.out.print(df.format(++Counter.counter));
		System.out.print(" - ");
		System.out.print(who.getName());
		System.out.print(" says");
		if(to!=null){
			System.out.print(" to ");
			System.out.print(to.getName());
		}
		System.out.print(": \"");
		System.out.print(text);
		System.out.print("\".");
	}

}
