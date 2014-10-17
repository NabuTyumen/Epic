package epic;

/**
 * @author Bruno
 *
 *The simplest 
 *and less structured mean
 *to write our Epic
 * ver. 01 - Gilgamesh says: "I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu".
 * ver. 02 - Enkidu says to Gilgamesh: "I am Enkidu, mortal son of Ninurta, immortal daughter of Enlil and Ninlil".
 * ver. 03 - Ishtar says to Gilgamesh: "I am Ishtar, immortal daughter of Anu".
 */
import java.util.HashMap;
public class A_Epic {

	
	static HashMap <Integer,String> getName(){
	HashMap<Integer,String> name = new HashMap<Integer,String>();
	name.put(1, "Gilgamesh");
	name.put(2, "Enkidu");
	name.put(3, "Ishtar");
	return name;
	}
	
	static HashMap <Integer,String> getGod(){
	HashMap<Integer,String> god = new HashMap<Integer,String>();
	god.put(1, "mortal");
	god.put(2, "immortal");
	return god;
	}

	static HashMap <Integer,String> getGender(){
	HashMap<Integer,String> gender = new HashMap<Integer,String>();
	gender.put(1, "son");
	gender.put(2, "daughter");	
	return gender;
	}
	
	static HashMap <Integer,String> getParents(){
	HashMap<Integer,String> parents = new HashMap<Integer,String>();
	parents.put(1, "Lugalbanda and Ninsun");
	parents.put(2, "Ninurta");
	parents.put(3, "Anu");	
	return parents;
	}
	
	public static void main(String[] args) {

		System.out.println("I am "+getName().get(1)+", "+getGod().get(1)+" "+getGender().get(1)+" of "+getParents().get(1));
		System.out.println("I am "+getName().get(2)+", "+getGod().get(1)+" "+getGender().get(1)+" of "+getParents().get(2));
		System.out.println("I am "+getName().get(3)+", "+getGod().get(2)+" "+getGender().get(2)+" of "+getParents().get(3));
			
	}
}