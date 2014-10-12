package epic;

import java.util.HashMap;

public class Person {
	private static int GILGAMESH = 1; 	//m
	private static int LUGALBANDA = 2; 	//m
	private static int NINSUN = 3; 		//w
	private static int ENKIDU = 4; 		//m
	private static int ANU = 5; 		//m
	private static int ISHTAR = 6; 		//w
	private static int NINURTA = 7; 	//m
	
	static HashMap<Integer,String> getNames(){
		HashMap<Integer,String> a = new HashMap<Integer, String>();
		a.put(GILGAMESH, "Gilgamesh");
		a.put(LUGALBANDA, "Lugalbanda");
		a.put(NINSUN, "Ninsun");
		a.put(ENKIDU, "Enkidu");
		a.put(ANU, "Anu");
		a.put(ISHTAR, "Ishtar");
		a.put(NINURTA, "Ninurta");
		return a;
	}
	
	static HashMap<Integer,Integer[]> getParents(){
		HashMap<Integer,Integer[]> a = new HashMap<Integer, Integer[]>();
		a.put(GILGAMESH, new Integer[]{LUGALBANDA, NINSUN});
		a.put(NINSUN, new Integer[]{null, ANU});
		a.put(ENKIDU, new Integer[]{null, NINURTA});
		a.put(ISHTAR, new Integer[]{null, ANU});
		return a;
	}
	
	static HashMap<Integer,String[]> getInfo() {
		HashMap<Integer,String[]> a = new HashMap<Integer, String[]>();
		a.put(GILGAMESH, new String[]{"son", "mortal"});
		a.put(NINSUN, new String[]{"daughter", "immortal"});
		a.put(ENKIDU, new String[]{"son", "mortal"});
		a.put(ISHTAR, new String[]{"daughter", "immortal"});
		a.put(NINURTA, new String[]{"daughter", "immortal"});
		return a;
	}
	
	static String printer(Integer person){
		String s = getNames().get(person);
		if (getInfo().get(person) != null)
			s = s + ", " + getInfo().get(person)[1];

		if (getParents().get(person) != null && getInfo().get(person) != null &&
				(getParents().get(person)[0] != null || getParents().get(person)[1] != null))
		{
			s = s  + " " + getInfo().get(person)[0] + " of ";
			if (getParents().get(person)[0] != null)
				s = s + printer(getParents().get(person)[0]);
			if (getParents().get(person)[1] != null)
			{
				if (getParents().get(person)[0] != null)
					s = s + " and ";
				s = s + printer(getParents().get(person)[1]);
			}
		}
		return s;
	}
	

	public static void main(String[] args) {
		for (Integer i=1; i<=getNames().size(); i++)
		{
			System.out.println(" ver. 0" + i + " - " + getNames().get(i) + " says: \"I am " + 
					printer(i) + ".\"");
		}
	}
}
