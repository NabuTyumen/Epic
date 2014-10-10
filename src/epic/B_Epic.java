package epic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Bruno
 *
 *The simplest 
 *and less structured mean
 *to write our Epic
 *
 */
public class A_Epic {
	
	public static String writer(int i){
		switch(i){
		case 1: return "Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\".";
		case 2: return "Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \".";
		case 3: return "Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \".";
		}
		return "";
	}
	
	public static void main(String[] args) {
		Map<Integer, String> w = new HashMap<Integer, String>();
		w.put(0, "Kristina");
		w.put(1, "Kate");
		w.put(2, "Jane");
		w.put(3, "Ishtar");
		
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(0, "Anton");
		m.put(1, "Kirill");
		m.put(2, "Andrey");
		m.put(3, "Enkidu");

		Random ran = new Random();		
		ran.nextInt(4);

		for (int i=1; i<4; i++)
		{
			int s = ran.nextInt(2);
			String n = "";
			String p = "";
			if (s==0)
			{
				p = "son";
				n=m.get(ran.nextInt(m.size() - 1));
			}
			else
			{
				p = "daughter";
				n=w.get(ran.nextInt(w.size() - 1));
			}
			String d = "";
			switch(ran.nextInt(2)) {
			case 0: d="mortal";
			case 1: d="immortal";
			}
			System.out.println("ver 0" + i + " - I am " + n + ", " + d + " " + p + " of " + m.get(ran.nextInt(m.size())) + " and " +  w.get(ran.nextInt(w.size())));
		}
	}
	
}
