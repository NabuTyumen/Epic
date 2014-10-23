
import java.util.HashMap;

/*switch(i){
case 1: return " ver. 01 - Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\"."; 
case 2: return " ver. 02 - Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \". ";
case 3: return " ver. 03 - Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \".";*/

public class mu {
	private static int GILGAMESH = 1;
	private static int Enkidu = 2;
	private static int Ishtar = 3;
	private static int Lugalbanda = 4;
	private static int Ninsun = 5;
	private static int Anu = 6;
	private static int Ninurta = 7;
	
	private static HashMap<Integer,String> name = getNames();
	private static HashMap<Integer,String> mortal_gender = getGenderAndMortal();
	private static HashMap<Integer,Integer[]> parants = getParents();
	
	
	public static void main(String[] args) {
		
		for (int i=1;i<name.size()+1;i++)
		{
			AllPersonInformation(i);
		}
	}
	
static void AllPersonInformation(int i){
		
		String srt = "I am "+ name.get(i);
		
		if (mortal_gender.get(i) != null)
		{
			srt = srt + ", " + mortal_gender.get(i);
			
			if (parants.get(i)[0] != null)
			{
				srt = srt + " of " + ParentPersonInformation(parants.get(i)[0]);
				
				if (parants.get(i).length > 1)
				{
					srt = srt + " and " + ParentPersonInformation(parants.get(i)[1]);
				}
			}			
		}

		System.out.println(srt);
	}
	
	static String ParentPersonInformation(int i){
		String srt = name.get(i);
		if (parants.get(i) != null)
		{
			if (parants.get(i).length >0 )
			{
				srt = srt + ", "+ mortal_gender.get(i) + " of " + ParentPersonInformation(parants.get(i)[0]);
			}
			
			if (parants.get(i).length >1 )
			{
				srt = srt + " and " + ParentPersonInformation(parants.get(i)[1]);
			}

		}
		return srt;
	}
	
	static HashMap<Integer,String> getNames(){
		HashMap<Integer,String> a = new HashMap<Integer, String>();
		a.put(GILGAMESH, "Gilgamesh");
		a.put(Enkidu, "Enkidu");
		a.put(Ishtar, "Ishtar");
		a.put(Lugalbanda, "Lugalbanda");
		a.put(Ninsun, "Ninsun");
		a.put(Anu, "Anu");
		a.put(Ninurta, "Ninurta");
		return a;
	}
	
	static HashMap<Integer,Integer[]> getParents(){
		HashMap<Integer,Integer[]> a = new HashMap<Integer, Integer[]>();
		a.put(GILGAMESH, new Integer[]{Lugalbanda,Ninsun});
		a.put(Enkidu, new Integer[]{Ninurta});
		a.put(Ishtar, new Integer[]{Anu});
		a.put(Ninsun, new Integer[]{Anu});
		return a;
	}
	
	static HashMap<Integer,String> getGenderAndMortal(){
		HashMap<Integer,String> a = new HashMap<Integer, String>();
		a.put(GILGAMESH, "mortal son");
		a.put(Enkidu, "mortal son");
		a.put(Ishtar, "immortal daughter");
		a.put(Ninsun, "immortal daughter");
		return a;
	}

}