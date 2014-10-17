package epic;

import java.util.HashMap;

public class C_Epic {
	
	public static class Human {
		private String name;
		private Human parent_1;
		private Human parent_2;
		private String info_1;
		private String info_2;
		public String getName() {
			return name;
		}
		public Human getParent_1() {
			return parent_1;
		}
		public Human getParent_2() {
			return parent_2;
		}
		public String getInfo_1() {
			return info_1;
		}
		public String getInfo_2() {
			return info_2;
		}
		void setInfo(String i1, String i2){
			this.info_1 = i1;
			this.info_2 = i2;
		}
		Human(String n, String i1, String i2, Human p1) {
			this.name = n;
			this.parent_1 = p1;
			setInfo(i1, i2);
		}
		Human(String n, String i1, String i2, Human p1, Human p2) {
			this.name = n;
			this.parent_1 = p1;
			this.parent_2 = p2;
			setInfo(i1, i2);
		}
		Human(String n, String i1, String i2) {
			this.name = n;
			setInfo(i1, i2);
		}
		
		String printer(){
			String s = getName();
			if (getInfo_2() != null)
				s = s + ", " + getInfo_2();

			if (getInfo_1() != null &&
					(getParent_1() != null || getParent_2() != null))
			{
				s = s  + " " + getInfo_1() + " of ";
				if (getParent_1() != null)
					s = s + getParent_1().printer();
				if (getParent_2() != null)
				{
					if (getParent_1() != null)
						s = s + " and ";
					s = s + getParent_2().printer();
				}
			}
			return s;
		}
	}

	static HashMap<Integer,Human> getHumans(){
		HashMap<Integer,Human> a = new HashMap<Integer, Human>();
		Human anu = new Human("Anu", null, null);
		Human lugalbanda = new Human("Lugalbanda", null, null);
		Human ninurta = new Human("Ninurta", "daughter", "immortal");
		Human ishtar = new Human("Ishtar", "daughter", "immortal", anu);
		Human enkidu = new Human("Enkidu", "son", "mortal", ninurta);
		Human ninsun = new Human("Ninsun", "daughter", "immortal", anu);
		Human gilgamesh = new Human("Gilgamesh", "son", "mortal", lugalbanda, ninsun);
		a.put(1, anu);
		a.put(2, lugalbanda);
		a.put(3, ninurta);
		a.put(4, ishtar);
		a.put(5, enkidu);
		a.put(6, ninsun);
		a.put(7, gilgamesh);
		return a;
	}

	public static void main(String[] args) {
		HashMap<Integer,Human> mas_humans = getHumans();
		for (Integer i=1; i<=mas_humans.size(); i++)
		{
			Human h = mas_humans.get(i);
			System.out.println(" ver. 0" + i + " - " + h.getName() + " says: \"I am " + 
					h.printer() + ".\"");
		}
	}
}
