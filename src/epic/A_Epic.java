package fist;

public class test {

	public static void main(String[] args) {
		
		for (int i=1;i<4;i++)
		{
			System.out.println(writei(i));
		}
	}
		public static String writei(int i)
		{
			switch(i){
			case 1: return " ver. 01 - Gilgamesh says: \"I am Gilgamesh, mortal son of Lugalbanda and Ninsun, immortal daughter of Anu\"."; 
			case 2: return " ver. 02 - Enkidu says to Gilgamesh: \"I am Enkidu, mortal son of Ninurta, immortal \". ";
			case 3: return " ver. 03 - Ishtar says to Gilgamesh: \"I am Ishtar, immortal daughter of Anu \"."; 
			}
			return "";
			}

}