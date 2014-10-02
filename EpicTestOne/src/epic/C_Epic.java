package epic;

import java.text.DecimalFormat;
import java.util.HashMap;

public class C_Epic {

	private static final HashMap<Integer, String> names = Persons.getNames();
	private static final HashMap<Integer, Integer[]> parents = Persons.getParents();
	private static final HashMap<Integer, Character> sexs =Persons.getSexs();
	private static final HashMap<Integer, Boolean> mortals = Persons.getMortals();

	private static String getLine(int line){
		switch(line){
		case 1: return introFactory(Persons.GILGAMESH, 0);
		case 2:  return introFactory(Persons.ENKIDU, Persons.GILGAMESH);
		case 3:  return introFactory(Persons.ISHTAR, Persons.GILGAMESH);
		default: return "";
		}
	}


	private static String introFactory(int person, int to){
		StringBuilder sb = new StringBuilder();
		sb.append(names.get(person));
		sb.append(" says");
		if(to!=0){
			sb.append(" to ");
			sb.append(names.get(to));
		}
		sb.append(": \"I am ");
		sb.append(names.get(person));
		sb.append(getFiliation(person));

		return sb.toString();
	}

	private static String  getFiliation(int c ) {
		if(c==0) return "";
		
		StringBuilder text = new StringBuilder("");
		Integer[] p = parents.get(c);
		if(p[0] != 0) {
			text.append(mortals.get(c)?", mortal ":", immortal ");
			text.append(sexs.get(c)=='M'?"son of ":"daughter of ");
			text.append(names.get(p[0]));
			text.append(getFiliation(p[0]));
		}
		if(p[1] != 0) {
			text.append(" and ");
			text.append(names.get(p[1]));
			text.append(getFiliation(p[1]));
		}
		return text.toString();
	}


	public static void main(String[] args) {

		//A object to format the line's number
		DecimalFormat df = new DecimalFormat("00");

		//A loop
		for(int line=1;line<4;line++){
			System.out.println();
			System.out.print("ver. ");
			System.out.print(df.format(line));
			System.out.print(" - ");
			System.out.print(getLine(line));
		}

	}

}
