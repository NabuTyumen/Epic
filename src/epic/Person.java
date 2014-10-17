package fist;

import java.util.HashMap;


public class Person {
	public static void main(String[] args) {
		HashMap<Integer,String> a = getNames();
		HashMap<Integer,Integer[]> b = getParents();
		for (int i=1;i<a.size()+1;i++)
		{
			
			String Outt = "I am "+ a.get(i) + ", " + GetMortal() + " " +  getGender(i) + " of " + a.get(b.get(i)[0])+ " and " + a.get(b.get(i)[1]);
			System.out.println(Outt);
		}
	}
	
	
	
	private static int GILGAMESH = 1;
	private static int VOVA = 2;
	private static int MAXIM = 3;
	private static int IRA = 4;
	private static int OLYA = 5;
	private static int KRISTINA = 6;
	//2 Enkidu
	
	static HashMap<Integer,String> getNames(){
		HashMap<Integer,String> a = new HashMap<Integer, String>();
		a.put(GILGAMESH, "Gilgamesh");
		a.put(VOVA, "Vova");
		a.put(MAXIM, "Maxim");
		a.put(IRA, "Ira");
		a.put(OLYA, "Olya");
		a.put(KRISTINA, "Kristina");
		return a;
	}
	
	static HashMap<Integer,Integer[]> getParents(){
		HashMap<Integer,Integer[]> a = new HashMap<Integer, Integer[]>();
		a.put(GILGAMESH, new Integer[]{3,4});
		a.put(VOVA, new Integer[]{1,4});
		a.put(MAXIM, new Integer[]{2,6});
		a.put(IRA, new Integer[]{3,5});
		a.put(OLYA, new Integer[]{1,4});
		a.put(KRISTINA, new Integer[]{2,5});
		return a;
	}
	
	static String getGender(int n){
		String v3 = "";
		if (n>3) 
		 {
			 v3 = "daughter";
		 }
		 else
		 {
			 v3 = "son";
		 }
		return v3;
		
	}
	
	static String GetMortal(){
		int v6 =(int)( Math.random()*2)+1;
		String v4 = "";
		 if (v6== 1) 
		 {
			 v4 = "immortal";
		 }
		 else
		 {
			 v4 = "mortal";
		 }
		 return v4;
	}
	

}