package epic.characters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

	@ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinTable(
			name="parent",
			joinColumns = @JoinColumn( name="id_child"),
			inverseJoinColumns = @JoinColumn( name="id_parent")
			)
	private List<Person> parents;

	@Column(name = "mortal")
	private boolean mortal;

	@Column(name = "gender")
	private char gender;


	public Person(int id,String name, String title, boolean mortal, char gender, ArrayList<Person> parents){
		setId(id);
		setName(name);
		setTitle(title);
		setMortal(mortal);
		setGender(gender);
		setParents(parents);

	}


	public void setParents(ArrayList<Person> ps) {
		parents = ps;

	}

	public Person(int id,String name, String title, String mortal, String gender, ArrayList<Person> parents) {
		setName(name);
		setTitle(title);
		setMortal("T".equals(mortal)?true:false);
		setGender("M".equals(gender)?'M':'F');
		setParents(parents);

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
		List<Person> ps = c.getParents();
		if( ps==null) return "";

		StringBuilder text = new StringBuilder("");
		int i=0;
		for(Person p:ps){
			if(i==0){
				text.append(c.mortal?", mortal ":", immortal ");
				text.append(c.gender=='M'?"son of ":"daughter of ");
			} else {
				text.append(" and ");
			}
			text.append(p.name);
			if(!infiniteLoop(c,p)){
				text.append(getFiliation(p));
			}
			i++;
		}


		return text.toString();
	}

	private boolean infiniteLoop(Person person, Person parent) {
		if(person == null) return true;
		if(parent == null) return true;
		if(person.equals(parent)) return true;
		if(parent.getParents()==null) return false;
		for(Person p: person.getParents()){
			if(person.equals(p)) return true;
		}
		return false;
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
	public List<Person> getParents() {
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
	public String getGenderStr() {
		return getGender()=='M'?"M":"F";
	}

	@Override
	public String toJSONString() {
		JSONObject json = new JSONObject() ;
		json.put("id", getId());
		json.put("name", getName());
		json.put("title", getTitle());
		json.put("mortal", getMortal());
		json.put("gender", getGenderStr());
		/*JSONArray ps = new JSONArray();
		ps.addAll(getParents());
		json.put("parents", ps);*/
		return json.toJSONString();
	}

	public void set(String field, String value) {
		if("name".equals(field)){
			setName(value);
		}else if("title".equals(field)){
			setTitle(value);
		} else if("gender".equals(field)){
			setGender(value.charAt(0));
		} else if("mortal".equals(field)){
			setMortal("T".equals(value)?true:false);
		}


	}
	public String toString(){
		StringBuilder sb = new StringBuilder(id);
		sb.append(", ");
		sb.append(name);
		sb.append(", ");
		sb.append(title);
		sb.append(", ");
		sb.append(mortal?"mortal":"immortal");
		sb.append(", ");
		sb.append(gender=='M'?"male":"female");
		sb.append(", parents:");
		for(Person p:getParents()){
			sb.append(p.name);
			sb.append(" / ");
		}
		return sb.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public boolean haveThisParents(Collection<Person> ps) {
		for(Person p:ps){
			if(!haveThisParent(p)) return false;
		}
		return true;
	}
	private boolean haveThisParent(Person person) {
		for(Person p:getParents()){
			if(p.equals(person)) return true;
		}
		return false;
	}
}
