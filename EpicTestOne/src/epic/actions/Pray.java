package epic.actions;

import epic.characters.Person;

public class Pray extends Act {
	
	Person to;
	String text;

	public Pray(Person who, Person to, String text) {
		this.who=who;
		this.to=to;
		this.text=text;
	}
	
	public void write(){
		System.out.println();
		System.out.print(" ver. ");
		System.out.print(super.df.format(++Counter.counter));
		System.out.print(" - ");
		System.out.print(this.who.getName());
		System.out.print(" beg");
		if(to!=null){
			System.out.print(" ");
   			System.out.print(this.to.getName());
		}
		System.out.print(": \"");
		System.out.print(text);
		System.out.print("\".");
	}

}
