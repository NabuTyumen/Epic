import java.util.HashMap;


public class Person {
	private static int GILGAMESH = 1;
	//2 Enkidu
	
	static HashMap<Integer,String> getNames(){
		HashMap<Integer,String> a = new HashMap<Integer, String>();
		a.put(GILGAMESH, "Gilgamesh");
		return a;
	}
	
	static HashMap<Integer,Integer[]> getParents(){
		HashMap<Integer,Integer[]> a = new HashMap<Integer, Integer[]>();
		a.put(GILGAMESH, new Integer[]{3,4});
		return a;
	}

}
