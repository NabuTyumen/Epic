
import java.util.HashMap;

public class Data {
	static final int GILGAMESH=1;
	static final int ENKIDU=2;
	static final int ISHTAR=3;
	static final int LUGAL=4;
	static final int NINSUN=5;
	static final int ANU=6;
	static final int NINURTA=7;
	static final int ENLIL=8;
	static final int NINLIL=9;
	
	static HashMap<Integer, String> getNames(){
		HashMap<Integer, String> names = new HashMap<Integer, String>();
		names.put(GILGAMESH, "Gilgamesh");
		names.put(ENKIDU, "Enkidu");
		names.put(ISHTAR, "Ishtar");
		names.put(LUGAL, "Lugalbanda");
		names.put(NINSUN, "Ninsun");
		names.put(ANU, "Anu");
		names.put(NINURTA, "Ninurta");
		names.put(ENLIL, "Enlil");
		names.put(NINLIL, "Ninlil");
		
		return names;
	}
	
	 static HashMap<Integer, Boolean> getMortals() {
		HashMap<Integer, Boolean> mortals = new HashMap<Integer, Boolean>();
		mortals.put(GILGAMESH, true);
		mortals.put(ENKIDU, true);
		mortals.put(ISHTAR, false);
		mortals.put(LUGAL, false);
		mortals.put(NINSUN, false);
		mortals.put(ANU, false);
		mortals.put(NINURTA, false);
		mortals.put(ENLIL, false);
		mortals.put(NINLIL, false);
		return mortals;
	}

	 static HashMap<Integer, Character> getGenders() {
		HashMap<Integer, Character> sexs = new HashMap<Integer, Character>();
		sexs.put(GILGAMESH, 'M');
		sexs.put(ENKIDU, 'M');
		sexs.put(ISHTAR, 'F');
		sexs.put(LUGAL, 'M');
		sexs.put(NINSUN, 'F');
		sexs.put(ANU, 'M');
		sexs.put(NINURTA, 'M');
		sexs.put(ENLIL, 'M');
		sexs.put(NINLIL, 'F');
		
		
		return sexs;
	}

	 static HashMap<Integer, Integer[]> getParents(){
		HashMap<Integer, Integer[]> parents = new HashMap<Integer, Integer[]>();
		parents.put(GILGAMESH, new Integer[]{LUGAL,NINSUN});
		parents.put(ENKIDU, new Integer[]{NINURTA,0});
		parents.put(ISHTAR, new Integer[]{ANU,0});
		parents.put(LUGAL, new Integer[]{0,0});
		parents.put(NINSUN, new Integer[]{ANU,0});
		parents.put(ANU, new Integer[]{0,0});
		parents.put(NINURTA, new Integer[]{ENLIL,NINLIL});
		parents.put(ENLIL, new Integer[]{ANU,0});
		parents.put(NINLIL, new Integer[]{0,0});
		
		return parents;
	}

}
