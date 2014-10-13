package epic.actions;

import epic.characters.Person;

public class Pray extends Speak {

	public Pray(Person who, Person to, String text) {
		super(who, to, text);
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
