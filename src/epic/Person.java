package solodkov.utmn.ru;

public class Person {

	public Person(String name, char gender, boolean mortal, Person father = null, Person mother = null)
	{
		_name = name;
		_gender = gender;
		_mortal = mortal;
		_person[0] = father;
		_person[1] = mother;
	}
	
	private String _name = "";
	
	private char _gender = 'm';
	
	private boolean _mortal = true;
	
	private Person[] _parents = new Person[2];
	
	public Speak introduce(){
		String txt = "I am ";
		txt+=_name;
		txt+=_mortal?"mortal ":"immortal ";
		switch (_gender){
		case 'm':txt+="son of";
		case 'f':txt+="daughter of";
		}
		if (_parents[0]!=null)
			txt+=" " + _parents[0];
		if (_parents[1]!=null)
			txt+=" " + _parents[1];
		
		s = new Speak(txt);
		return s;
	}
	
	
	
	
}
