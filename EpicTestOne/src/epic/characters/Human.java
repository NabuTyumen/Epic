package epic.characters;

import epic.actions.Speak;

public class Human extends Person implements Worshiper{
	
	public Human(int id,String name, char sex, Person[] parents){
		this.id=id;
		this.name=name;
		this.gender=sex;
		this.parents=parents;
		this.mortal=true;
	}

	@Override
	public Speak pray(God to) {
		//pray his god
				StringBuilder text = new StringBuilder("O ");
				text.append(to.name);
				text.append(addParentalTitle(to, ""));
				text.append(" may your protection come upon");
				text.append(addChildTitle(to, " thy servent"));
				//create a Speak
				Speak prayer = new Speak(this, to, text.toString());
				return prayer;
	}

	private String addParentalTitle(Person to, String subst) {
		for(Person p:getParents()){
			if(to.equals(p)) {
				StringBuilder text = new StringBuilder(", my ");
				text.append(p.getParentalTitle());
				return text.toString();
				}
			
		}
		return subst;
	}
	private String addChildTitle(Person to, String subst) {
		for(Person p:getParents()){
			if(to.equals(p)) {
				StringBuilder text = new StringBuilder(" me, your ");
				text.append(getChildTitle());
				return text.toString();
				}
			
		}
		return subst;
	}
	@Override
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
			text.append(", mortal ");
			text.append(c.gender=='M'?"son of ":"daughter of ");
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

	

	



	
	

}
