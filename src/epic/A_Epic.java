package epic;

/**
 * @author Bruno
 *
 *The simplest 
 *and less structured mean
 *to write our Epic
 *
 */
public class A_Epic {

	
	public static String myfunc(int i) {
		switch(i) {
			case 1: return "ver. 01 - Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\".\n";
			case 2: return "ver. 02 - Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \".\n";
			case 3: return "ver. 03 - Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \".\n";
		}
		return " ";
	}

	public static void main(String[] args) {
		
		for (int i=1; i <= 10; i++) {
 			System.out.print(myfunc(i));
		}
		
	}
}
