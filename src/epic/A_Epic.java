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

	public static void main(String[] args) {
		String[] arNames = ("Gilgamesh","Enkidu","Ishtar");
		String[] arType = ("mortal", "immortal");
		String[] arGender = ("man", "woman");
		String[] arParents = ("Lugalbanda", "Anu", "Ninurta", "Ninsun");
		
		
		for (int i=1; i<4; i++) {
			System.out.println(write_i(i));		
		}

	}
}
