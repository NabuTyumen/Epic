package epic;

import java.util.ArrayList;
import java.util.List;




public class Epic {
	
	public static void main(String[] args) {
		List<Speak> actions = new ArrayList<Speak>();

		Person anu = new Person(Data.ANU, new Person[]{null, null});
		Person ishtar = new Person(Data.ISHTAR, new Person[]{anu, null});
		Person ninlin = new Person(Data.NINLIL, new Person[]{null, null});
		Person enlil = new Person(Data.ENLIL, new Person[]{anu, ninlin});
		Person ninurta = new Person(Data.NINURTA, new Person[]{enlil, null});
		Person enkidu = new Person(Data.ENKIDU, new Person[]{ninurta, null});
		Person ninsun = new Person(Data.NINSUN, new Person[]{anu, null});
		Person lugalbanda = new Person(Data.LUGAL, new Person[]{null, null});
		Person gilgamesh = new Person(Data.GILGAMESH, new Person[]{lugalbanda, ninsun});
		actions.add(gilgamesh.introduce(null));
		actions.add(enkidu.introduce(gilgamesh));
		actions.add(ishtar.introduce(gilgamesh));
		
		for(Speak s:actions) {
			System.out.println(s.write());
		}
	}

}
