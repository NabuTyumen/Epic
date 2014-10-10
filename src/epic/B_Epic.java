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
	
	public static String writer(int i){
		switch(i){
		case 1: return "Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun \".";
		case 2: return "Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta \".";
		case 3: return "Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \".";
		}
		return "";
	}
	
	public static void main(String[] args) {
		for (int i=1; i<4; i++)
		{
			System.out.println(" ver. 0" + i + " - " + writer(i));
		}
	}
	
}
