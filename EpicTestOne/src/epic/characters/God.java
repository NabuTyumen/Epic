package epic.characters;


public class God extends Person{
	
public God(int id,String name, char gender, Person[] parents){
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.parents=parents;
		this.mortal=false;
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
		text.append(", immortal ");
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
