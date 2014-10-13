package epic;

import java.util.ArrayList;
import java.util.List;

import epic.actions.Speak;
import epic.characters.Person;
public class Epic {
	
	static final int GILGAMESH=1;
	static final int ENKIDU=2;
	static final int ISHTAR=3;
	static final int LUGAL=4;
	static final int NINSUN=5;
	static final int ANU=6;
	static final int NINURTA=7;
	static final int ENLIL=8;
	static final int NINLIL=9;

	private static List<Speak> actions;


	public static List<Speak> getActions() {
		return actions;
	}

	
	public static void tellMe(List<Speak> actions) {
		for(Speak a:actions){
			a.write();
		}
	}
	

	public static void main(String[] args) {

		/********************************
		/** Creation of the characters **
		/********************************/
		
		//ANU God of Heaven
		Person anu = new Person(ANU,"Anu",false,'M',null);

		//ISHTAR Goddess of Love
		Person[] pIshtar = {anu,null};
		Person ishtar = new Person(ISHTAR, "Ishtar",false,'F',pIshtar);
		
		//Enlil Lord of the Storm
		Person enlil = new Person(ENLIL, "Enlil",false,'M',null);
		
		//NINLIL Wife of Enlil
		Person ninlil = new Person(NINLIL,"Ninlil",false,'F',null);
		
		//NINURTA God of War
		Person[] pNinurta = {enlil,ninlil};
		Person ninurta = new Person(NINURTA,"Ninurta",false,'F',pNinurta);
		
		//NINSUN, the Lady Wild Cow
		Person[] pNinsun = {anu,null};
		Person ninsun = new Person(NINSUN,"Ninsun",false,'F',pNinsun);
		
		//LULGALBANDA Third King of Uruk
		Person lugal = new Person(LUGAL,"Lugalbanda",true,'M',null);
		
		//GILGAMESH Fifth King of Uruk
		Person[] pGilgamesh = {lugal,ninsun};
		Person gilgamesh = new Person(GILGAMESH,"Gilgamesh",true,'M',pGilgamesh);
		
		//ENKIDU Friend of Gilgamesh
		Person[] pEnkidu = {ninurta,null};
		Person enkidu = new Person(ENKIDU,"Enkidu",true,'M',pEnkidu);
		

		/********************************
		/** Creation of the actions    **
		/********************************/
		
		actions = new ArrayList<Speak>();
		actions.add(gilgamesh.introduce(null));
		actions.add(enkidu.introduce(gilgamesh));
		actions.add(ishtar.introduce(gilgamesh));
		
		/********************************
		/** Now, tell the story        **
		/********************************/
		
		tellMe(actions);


	}






}
