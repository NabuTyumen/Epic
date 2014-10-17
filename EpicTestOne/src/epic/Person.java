
public class Person {
	String name;
	char gender;
	boolean mortal;
	Person[] parents;
	
	public Person(int key, Person[] p){
		name = Data.getNames().get(key);
		gender = Data.getGenders().get(key);
		mortal = Data.getMortals().get(key);
		parents = p;		
	}
	public Person(int key){
		name = Data.getNames().get(key);
		gender = Data.getGenders().get(key);
		mortal = Data.getMortals().get(key);	
	}

	private String introFactory(){
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" says");
		/*if(to!=0){
			sb.append(" to ");
			sb.append(names.get(to));
		}*/
		sb.append(": \"I am ");
		sb.append(name);
		sb.append(getFiliation());

		return sb.toString();
	}

	private String  getFiliation() {
		StringBuilder text = new StringBuilder("");
		if(parents[0] != null) {
			text.append(mortal?", mortal ":", immortal ");
			text.append(gender=='M'?"son of ":"daughter of ");
			text.append(parents[0].name);
			text.append(parents[0].getFiliation());
		}
		if(parents[1] != null) {
			text.append(" and ");
			text.append(parents[1].name);
			text.append(parents[1].getFiliation());
		}
		return text.toString();
	}
	
	public Speak introduce() {
		String txt = introFactory();
		Speak s = new Speak(txt);
		return s;
	}

}
