package epic.characters;

import epic.actions.Pray;


/**
 * @author Bruno
 * 
 * As God, humans are persons = extends the same abstract class Person
 * Only humans pray = only class Human implements interface Worshiper
 *
 */
public class Human extends Person implements Worshiper{

	
	/**
	 * Constructor of a Human
	 * 
	 * 
	 * @param id
	 * @param name
	 * @param gender
	 * @param parents
	 */
	public Human(int id,String name, char gender, Person[] parents){
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.parents=parents;
	}

	/* (non-Javadoc)
	 * @see epic.characters.Worshiper#pray(epic.characters.God)
	 */
	@Override
	public  Pray pray(God to) {
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
