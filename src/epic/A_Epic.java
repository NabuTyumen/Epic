package epic;


public class A_Epic {

	public static void main(String[] args) {
		for (int i=1; i<4; i++)  {
			System.out.println(i +" " +  write(i));	
		}
	}
		
		
	
	public static String write(int i)  {
		switch(i)
		{
		case 1: return "Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\".";
		case 2: return "Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \".";
		case 3: return "Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \"."		;
		}
		return "";
		
}
