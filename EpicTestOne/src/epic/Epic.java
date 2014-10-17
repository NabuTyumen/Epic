import java.util.ArrayList;
import java.util.List;




public class Epic {
	
	public static void main(String[] args) {
		List<Speak> actions = new ArrayList<Speak>();

		Person anu = new Person(Data.ANU);
		Person ishtar = new Person(Data.ISHTAR, new Person[]{anu});
		Person ninlin = new Person(Data.NINLIL);
		Person enlil = new Person(Data.ENLIL, new Person[]{anu, ninlin});
		Person ninurta = new Person(Data.NINURTA, new Person[]{enlil});
		Person enkidu = new Person(Data.ENKIDU, new Person[]{ninurta});
		Person ninsun = new Person(Data.NINSUN, new Person[]{anu});
		Person lugalbanda = new Person(Data.LUGAL);
		Person gilgamesh = new Person(Data.GILGAMESH, new Person[]{lugalbanda, ninsun});
		actions.add(gilgamesh.introduce());
		actions.add(enkidu.introduce());
		actions.add(ishtar.introduce());
		
		for(Speak s:actions) {
			System.out.println(s.write());
		}
	}

}
