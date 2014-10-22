package epic.characters;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import epic.actions.Speak;

@Entity
@Table(name = "person")
public class Person implements JSONAware {
	   @Id @GeneratedValue
	   @Column(name = "id")
	private int id;
	   
	   @Column(name = "name")
	private String name;
	   
	   @Column(name = "title")
	private String title;
	private ArrayList<Person> parents;
	
	@Column(name = "mortal")
	private boolean mortal;
	
	@Column(name = "gender")
	private char gender;


public Person(int id,String name, String title, boolean mortal, char gender){
		setId(id);
		setName(name);
		setTitle(title);
		setMortal(mortal);
		setGender(gender);
		//setParents(parents);
		
	}

	public Person(int id,String name, String title, String mortal, String gender) {
		setId(id);
		setName(name);
		setTitle(title);
		setMortal("T".equals(mortal)?true:false);
		setGender("M".equals(gender)?'M':'F');
		//setParents(parents);
		
}

	/**
	 * Empty constructor 
	 * needed by  Hibernate 
	 */
	public Person() {
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
		ArrayList<Person> p = c.getParents();
		if(p.isEmpty()) return "";
		
		StringBuilder text = new StringBuilder("");
		if(p.get(0) != null) {
			text.append(c.mortal?", mortal ":", immortal ");
			text.append(c.gender=='M'?"son of ":"daughter of ");
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
		if(ps!=null){
			for(Person p:ps){
				parents.add(p);
			}
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
	public char getGender() {
		return gender;
	}

	public void setGender(char s) {
		this.gender = s;
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
		return getGender()=='M'?"M":"F";
	}

	@Override
	public String toJSONString() {
		JSONObject json = new JSONObject() ;
		json.put("id", getId());
		json.put("name", getName());
		json.put("title", getTitle());
		json.put("mortal", getMortal());
		json.put("sex", getSexStr());
		/*JSONArray ps = new JSONArray();
		ps.addAll(getParents());
		json.put("parents", ps);*/
		return json.toJSONString();
	}

}
