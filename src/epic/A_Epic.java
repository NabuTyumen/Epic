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

	public static void main(String[] args) 
	{
		System.out.print(" ver. 01 - Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\".");
		System.out.print(" ver. 02 - Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \".");
		System.out.print(" ver. 03 - Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \".");
		
		for (int i=0; i<4; i++)
			{
			System.out.println(" ver. 0" + i + write (i));
			}
	}
	
	public static String write(int i) 
	{
		switch (i)
		{
			case 1:return "- Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\".";
			case 2:return "- Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \".";
			case 3:return "- Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \".";
		}
		return "";
	}

}
