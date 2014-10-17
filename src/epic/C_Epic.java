package epic;

import java.util.HashMap;

public class C_Epic {
	
	static HashMap<Integer,Human> getHumans(){
		HashMap<Integer,Human> a = new HashMap<Integer, Human>();
		Human anu = new Human("Anu", null, null);
		Human lugalbanda = new Human("Lugalbanda", null, null);
		Human ninurta = new Human("Ninurta", "daughter", "immortal");
		Human ishtar = new Human("Ishtar", "daughter", "immortal", anu);
		Human enkidu = new Human("Enkidu", "son", "mortal", ninurta);
		Human ninsun = new Human("Ninsun", "daughter", "immortal", anu);
		Human gilgamesh = new Human("Gilgamesh", "son", "mortal", lugalbanda, ninsun);
		a.put(1, anu);
		a.put(2, lugalbanda);
		a.put(3, ninurta);
		a.put(4, ishtar);
		a.put(5, enkidu);
		a.put(6, ninsun);
		a.put(7, gilgamesh);
		return a;
	}

	public static void main(String[] args) {
		HashMap<Integer,Human> mas_humans = getHumans();
		for (Integer i=1; i<=mas_humans.size(); i++)
		{
			Human h = mas_humans.get(i);
			System.out.println(" ver. 0" + i + " - " + h.getName() + " says: \"I am " + 
					h.printer() + ".\"");
		}
	}
}
