package epic.characters;

import epic.actions.Pray;
import epic.actions.Speak;

public class Human extends Person implements Worshiper{

	
	/**
	 * Constructor of a Human
	 * @param id
	 * @param name
	 * @param sex
	 * @param parents
	 */
	public Human(int id,String name, char sex, Person[] parents){
		this.id=id;
		this.name=name;
		this.gender=sex;
		this.parents=parents;
	}

	/* (non-Javadoc)
	 * @see epic.characters.Worshiper#pray(epic.characters.God)
	 */
	@Override
	public Speak pray(God to) {
		//invoque his god
		StringBuilder text = new StringBuilder("O ");
		
		//add the god's name
		text.append(to.name);
		
		//if child of this god : mention it
		text.append(addParentalTitle(to, ""));
		
		//body of the prayer
		text.append(" may your protection come upon");
		
		//if child of this god : mention it, again !
		text.append(addChildTitle(to, " thy servent"));
		
		//create a Pray
		Pray prayer = new Pray(this, to, text.toString());
		
		//return a Pray
		return prayer;
	}



	/* (non-Javadoc)
	 * @see epic.characters.Person#getMortal()
	 */
	@Override
	public String getMortal() {
		return "mortal";
	}










}
