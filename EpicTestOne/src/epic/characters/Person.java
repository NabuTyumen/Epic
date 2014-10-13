package epic.characters;

import epic.actions.Speak;
import epic.characters.Speaker;

/**
 * @author Bruno
 * 
	 * Compared to the branch "object_simple"
	 * this is a ABSTRACT class.
	 * To implement a person, we need to implement 
	 * one of the inherited classes :
	 * Human or God
	 * 
	 * Note that there is no more property "mortal" because by definition 
	 * - all humans ARE mortal, 
	 * - all gods ARE immortal 
	 * (that is lighten the constructor of the inherited class 
	 * but instead a new method getMortal which return a String
 */

public abstract class Person implements Speaker, Scion{
	
	protected int id;
	protected String name;
	protected Person[] parents;
	protected char gender;
	
	/**
	 * ABSTRACT method : must be implemented 
	 * by the inherited classes
	 * to give :
	 * for a Human -> "mortal"
	 * for a God -> "immortal"
	 * @return
	 */
	public abstract String getMortal();
	
	@Override
	/**
	 * Implementation of the interface Speaker
	 * Method creating a Speak introducing a character
	 * 
	 * God and Human both introduce themselves 
	 * in a same way so the method could be inherited by the both classes
	 * 
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
	 * Constructing a Speak, or a Pray
	 * we need to access to the name 
	 * of the person.
	 * Here is the getter of this property
	 * 
	 * @return
	 */
	public	String getName() {
		return name;
	}
	
	/**
	 * The property "parents" has only a  
	 * internal access, so basically 
	 * we would needn't a getter for it
	 * 
	 * But this property could be NULL
	 * that will cause a NullPointerException 
	 * if we want iterate on it
	 * so the getter will test the null value 
	 * and fix it by setting a empty Collection
	 * 
	 * 
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



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * To test the identity of a Person
	 * nothing like a id !
	 * 
	 * Instead of test it with the name
	 * (risk of homonymie of the character)
	 * we test the identity which a unique id
	 */
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
