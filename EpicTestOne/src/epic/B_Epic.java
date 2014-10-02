package epic;

import java.text.DecimalFormat;

public class B_Epic {
	
	private static String getLine(int line){

		switch(line){
		case 1: return "Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\".";
		case 2: return "Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \".";
		case 3: return "Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \".";
		default: return "";
		}
		

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
