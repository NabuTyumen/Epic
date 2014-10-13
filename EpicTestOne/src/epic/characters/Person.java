package epic.characters;

import epic.actions.Speak;





public class Person {
	
	

	
	int id;
	String name;
	Person[] parents;
	public boolean mortal;
	public char gender;
	
	public Person(int id,String name, boolean mortal, char gender, Person[] parents){
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.mortal=mortal;
		this.parents=parents;
		this.mortal=true;
	}
	

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
	 * This method appends in a recursive way 
	 * the parentage of each parent of a Character
	 * @param c
	 * @return
	 */
	public String  getFiliation(Person c ) {
		if(c==null) return "";
		
		StringBuilder text = new StringBuilder("");
		Person[] p = c.getParents();
		if(p[0] != null) {
			text.append(", ");
			text.append(mortal?"mortal":"immortal");
			text.append(c.gender=='M'?" son of ":" daughter of ");
			text.append(p[0].name);
			text.append(getFiliation(p[0]));
		}
		if(p[1] != null) {
			text.append(" and ");
			text.append(p[1].name);
			text.append(getFiliation(p[1]));
		}
		return text.toString();
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
