package epic.characters;


public class God extends Person{
	
/**
 * Constructor of a God
 * @param id
 * @param name
 * @param gender
 * @param parents
 */
public God(int id,String name, char gender, Person[] parents){
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.parents=parents;
	}

/* (non-Javadoc)
 * @see epic.characters.Person#getMortal()
 */
@Override
public String getMortal() {
	return "immortal";
}


	


	



	



}
