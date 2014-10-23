package epic;

import java.util.ArrayList;
import java.util.List;

import epic.actions.Act;
import epic.characters.ManagePerson;
import epic.characters.Person;
public class Epic {

	private static List<Act> actions;
	private static List<Person> persons;

	public static List<Person> getPersons() {
		if(persons == null){
			persons=ManagePerson.getPersons();
		}
		return persons;
	}

	public static List<Act> getActions() {
		if(actions == null){
			actions = new ArrayList<Act>();
			for(Person p:getPersons()){
				actions.add(p.introduce(null));
			}
		}
		return actions;
	}

	public static  List<Act>  getActions(String parameter) {
		
		if(parameter==null) return getActions();
		
		int n = 3;
		try{
			n=Integer.parseInt(parameter);
		} catch(Exception e){
			
		}
		
		List<Act> actions = new ArrayList<Act>();
		int i=0;
		for(Act a:getActions()){
			if(i>=n) break;
				actions.add(a);
				i++;
		}
		
		return actions;
	}

	

}
