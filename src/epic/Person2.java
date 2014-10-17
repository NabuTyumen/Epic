package epic;

import java.util.HashMap;


public class Person2 {
	public String Name;
	public char Gender;
	public boolean Mortal;
	public Person2[] Parants;
	
	
	
	static final int GILGAMESH=1;
	static final int ENKIDU=2;
	static final int ISHTAR=3;
	static final int LUGAL=4;
	static final int NINSUN=5;
	static final int ANU=6;
	static final int NINURTA=7;
	static final int ENLIL=8;
	static final int NINLIL=9;
	
	public Person2(int i, Person2[] p) {
		this.Name = getNames().get(i);
		this.Gender = getGenders().get(i);
		this.Mortal = getMortals().get(i);
		this.Parants = p;
		
	}

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
	
	private String introFactory(int person, int to){
		StringBuilder sb = new StringBuilder();
		sb.append(Name);
		sb.append(" says");
		if(to!=0){
			sb.append(" to ");
			sb.append(Name);
		}
		sb.append(": \"I am ");
		sb.append(Name);
		sb.append(getFiliation(i));

		return sb.toString();
	}

	private String  getFiliation(int c ) {
		if(c==0) return "";
		
		StringBuilder text = new StringBuilder("");
		Integer[] p = parents.get(c);
		if(p[0] != 0) {
			text.append(Mortal?", mortal ":", immortal ");
			text.append(Gender=='M'?"son of ":"daughter of ");
			text.append(Name);
			text.append(getFiliation(p[0]));
		}
		if(p[1] != 0) {
			text.append(" and ");
			text.append(Name);
			text.append(getFiliation(p[1]));
		}
		return text.toString();
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

	 	
	
	
	public Speak introduce(){
		String txt=Name + " ";
		Speak s = new Speak(txt);
		return s;
	}
	

}