package epic.characters;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import epic.actions.Speak;


public class Person implements JSONAware{
	private int id;
	private String name;
	private String title;
	private ArrayList<Person> parents;
	private boolean mortal;
	private char sex;
	
public Person(int id,String name, String title, boolean mortal, char sex, Person[] parents){
		
		setName(name);
		setTitle(title);
		setMortal(mortal);
		setSex(sex);
		setParents(parents);
		
	}

	public Person(int id,String name, String title, String mortal, String sex, Person[] parents) {
		
		setName(name);
		setTitle(title);
		setMortal("T".equals(mortal)?true:false);
		setSex("M".equals(sex)?'M':'F');
		setParents(parents);
		
}

	/**
	 * Method creating a Speak 
	 * introducing a character
	 * @param to
	 * @return
	 */
	public Speak introduce(Person to) {
		
		//create the first words of a Speak
		StringBuilder text = new StringBuilder("I am ");
		text.append(this.name);
		text.append(getFiliation(this));
		
		//create a Speak
		Speak intro = new Speak(this, to, text.toString());
		
		return intro;
	}
	
	/**
	 * This method appends in a recursive way 
	 * the parentage of each parent of a Character
	 * @param c
	 * @return
	 */
	private String  getFiliation(Person c ) {
		if(c==null) return "";
		
		StringBuilder text = new StringBuilder("");
		ArrayList<Person> p = c.getParents();
		if(p.get(0) != null) {
			text.append(c.mortal?", mortal ":", immortal ");
			text.append(c.sex=='M'?"son of ":"daughter of ");
			text.append(p.get(0).name);
			text.append(getFiliation(p.get(0)));
		}
		for(int i=1;i<p.size();i++){
			if(p.get(i) != null) {
				text.append(" and ");
				text.append(p.get(i).name);
				text.append(getFiliation(p.get(i)));
			}
		}
		
		return text.toString();
	}

	/**
	 * @return
	 */
	public	String getName() {
		return name;
	}
	
	public	String setName(String n) {
		return this.name=n;
	}
	
	/**
	 * @return
	 */
	public ArrayList<Person> getParents() {
		if(parents == null){
			parents = new ArrayList<Person>();
		}
			
		return parents;
	}
	public void setParents(Person[] ps) {
		parents =  new ArrayList<Person>();
		for(Person p:ps){
			parents.add(p);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String t) {
		this.title = t;
	}
	
	public boolean getMortal() {
		return mortal;
	}

	public void setMortal(boolean m) {
		this.mortal = m;
	}
	public char getSex() {
		return sex;
	}

	public void setSex(char s) {
		this.sex = s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMortalStr() {
		return getMortal()?"T":"F";
	}
	public String getSexStr() {
		return getSex()=='M'?"M":"F";
	}

	@Override
	public String toJSONString() {
		JSONObject json = new JSONObject() ;
		json.put("id", getId());
		json.put("title", getTitle());
		json.put("mortal", getMortal());
		json.put("sex", getSex());
		JSONArray ps = new JSONArray();
		ps.addAll(getParents());
		return json.toJSONString();
	}

}
