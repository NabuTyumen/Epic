package epic.characters;

import epic.actions.Speak;
import epic.characters.Speaker;




public abstract class Person implements Speaker, Scion{
	

	
	int id;
	String name;
	Person[] parents;
	public boolean mortal;
	public char gender;
	
	@Override
	/**
	 * Implementation of the
	 * interface Speaker
	 * Method creating a Speak 
	 * introducing a character
	 * @param to
	 * @return
	 */
	public Speak introduce(Person to) {
		
		//create the first words of a Speak
		StringBuilder text = new StringBuilder("I am ");
		text.append(this.name);
		text.append(getFiliation(this));
		
		//create a Speak
		Speak intro = new Speak(this, to, text.toString());
		
		return intro;
	}
	
	

	/**
	 * @return
	 */
	public	String getName() {
		return name;
	}
	
	
	/**
	 * @return
	 */
	public Person[] getParents() {
		if(parents == null){
			Person[] parents = {null,null};
			setParents(parents);
		}
			
		return parents;
	}
	public void setParents(Person[] p) {
		parents = p;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public String getParentalTitle() {
		switch(gender){
		case 'M': return "father";
		case 'F': return "mother";
		}
		return "";
	}
	
	public String getChildTitle() {
		switch(gender){
		case 'M': return "son";
		case 'F': return "daughter";
		}
		return "";
	}

}
