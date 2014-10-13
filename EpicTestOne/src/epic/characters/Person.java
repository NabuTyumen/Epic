package epic.characters;

import epic.actions.Speak;
import epic.characters.Speaker;

public abstract class Person implements Speaker, Scion{
	
	protected int id;
	protected String name;
	protected Person[] parents;
	protected char gender;
	
	@Override
	/**
	 * Implementation of the interface Speaker
	 * Method creating a Speak introducing a character
	 * @param to
	 * @return
	 */
	public Speak introduce(Person to) {
		
		//create the first words of a Speak introducing himself
		StringBuilder text = new StringBuilder("I am ");
		
		//append his name
		text.append(this.name);
		
		//add recursively his parentage
		text.append(getFiliation(this));
		
		//create a Speak
		Speak intro = new Speak(this, to, text.toString());
		
		//return a Speak  
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
	
	/**
	 * @param p
	 */
	public void setParents(Person[] p) {
		parents = p;
	}



	/**
	 * @param to
	 * @param subst
	 * @return
	 */
	protected String addParentalTitle(Person to, String subst) {
		for(Person p:getParents()){
			if(to.equals(p)) {
				StringBuilder text = new StringBuilder(", my ");
				text.append(p.getParentalTitle());
				return text.toString();
				}
			
		}
		return subst;
	}
	/**
	 * @param to
	 * @param subst
	 * @return
	 */
	protected String addChildTitle(Person to, String subst) {
		for(Person p:getParents()){
			if(to.equals(p)) {
				StringBuilder text = new StringBuilder(" me, your ");
				text.append(getChildTitle());
				return text.toString();
				}
			
		}
		return subst;
	}

	/**
	 * @return
	 */
	protected String getParentalTitle() {
		switch(gender){
		case 'M': return "father";
		case 'F': return "mother";
		}
		return "";
	}
	
	/**
	 * @return
	 */
	protected String getChildTitle() {
		switch(gender){
		case 'M': return "son";
		case 'F': return "daughter";
		}
		return "";
	}
	
	public abstract String getMortal();
	
	/**
	 * This method appends in a recursive way 
	 * the parentage of each parent of a Person
	 * @param c
	 * @return
	 */
	public String  getFiliation(Person c ) {
		if(c==null) return "";
		
		StringBuilder text = new StringBuilder("");
		Person[] p = c.getParents();
		if(p[0] != null) {
			text.append(",");
			text.append(getMortal());
			text.append(" ");
			text.append(c.getChildTitle());
			text.append(" of ");
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

}
