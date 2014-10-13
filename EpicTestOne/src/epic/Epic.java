package epic;

import java.util.ArrayList;
import java.util.List;

import epic.actions.Act;
import epic.characters.Person;
import epic.characters.God;
import epic.characters.Human;
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

	private static List<Act> actions;
	

	public static void main(String[] args) {

		/********************************
		/** Creation of the characters **
		/********************************/
		
		//ANU God of Heaven
		God anu = new God(ANU,"Anu",'M',null);

		//ISHTAR Goddess of Love
		Person[] pIshtar = {anu,null};
		God ishtar = new God(ISHTAR, "Ishtar",'F',pIshtar);
		
		//Enlil Lord of the Storm
		God enlil = new God(ENLIL, "Enlil",'M',null);
		
		//NINLIL Wife of Enlil
		God ninlil = new God(NINLIL,"Ninlil",'F',null);
		
		//NINURTA God of War
		Person[] pNinurta = {enlil,ninlil};
		God ninurta = new God(NINURTA,"Ninurta",'F',pNinurta);
		
		//NINSUN, the Lady Wild Cow
		Person[] pNinsun = {anu,null};
		God ninsun = new God(NINSUN,"Ninsun",'F',pNinsun);
		
		//LULGALBANDA Third King of Uruk
		Human lugal = new Human(LUGAL,"Lugalbanda",'M',null);
		
		//GILGAMESH Fifth King of Uruk
		Person[] pGilgamesh = {lugal,ninsun};
		Human gilgamesh = new Human(GILGAMESH,"Gilgamesh",'M',pGilgamesh);
		
		//ENKIDU Friend of Gilgamesh
		Person[] pEnkidu = {ninurta,null};
		Human enkidu = new Human(ENKIDU,"Enkidu",'M',pEnkidu);
		

		/********************************
		/** Creation of the actions    **
		/********************************/
		
		actions = new ArrayList<Act>();
		actions.add(gilgamesh.introduce(null));
		actions.add(enkidu.introduce(gilgamesh));
		actions.add(ishtar.introduce(gilgamesh));
		actions.add(gilgamesh.pray(ninsun));
		actions.add(enkidu.pray(enlil));
		
		/********************************
		/** Now, tell us the story        **
		/********************************/
		
		for(Act a:actions){
			a.write();
		}


	}






}
