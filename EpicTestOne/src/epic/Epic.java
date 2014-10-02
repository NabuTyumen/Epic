package epic;

import java.util.ArrayList;
import java.util.List;

import epic.actions.Act;
import epic.characters.Person;
import epic.characters.God;
import epic.characters.Human;
public class Epic {

	private static List<Act> actions;


	public static List<Act> getActions() {
		if(actions == null){
			buildStory();
		}
		return actions;
	}

	public static void buildStory(){
		/********************************
		/** Creation of the characters **
		/********************************/
		
		//ANU God of Heaven
		Person anu = new God("Anu",'M');

		//ISHTAR Goddess of Love
		Person[] pIshtar = {anu,null};
		Person ishtar = new God("Ishtar",'F',pIshtar);
		
		//Enlil Lord of the Storm
		Person enlil = new God("Enlil",'M');
		
		//NINLIL Wife of Enlil
		Person ninlil = new God("Ninlil",'F');
		
		//NINURTA God of War
		Person[] pNinurta = {enlil,ninlil};
		Person ninurta = new God("Ninurta",'F',pNinurta);
		
		//NINSUN, the Lady Wild Cow
		Person[] pNinsun = {anu,null};
		Person ninsun = new God("Ninsun",'F',pNinsun);
		
		//LULGALBANDA Third King of Uruk
		Person lugal = new Human("Lugalbanda",'M',null);
		
		//GILGAMESH Fifth King of Uruk
		Person[] pGilgamesh = {lugal,ninsun};
		Person gilgamesh = new Human("Gilgamesh",'M',pGilgamesh);
		
		//ENKIDU Friend of Gilgamesh
		Person[] pEnkidu = {ninurta,null};
		Person enkidu = new Human("Enkidu",'M',pEnkidu);
		

		/********************************
		/** Creation of the actions    **
		/********************************/
		
		actions = new ArrayList<Act>();
		actions.add(gilgamesh.introduce(null));
		actions.add(enkidu.introduce(gilgamesh));
		actions.add(ishtar.introduce(gilgamesh));
	}

}
