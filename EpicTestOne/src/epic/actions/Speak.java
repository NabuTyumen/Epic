package epic.actions;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import epic.characters.Person;


/**
 * @author Bruno
 * 
 * Inherit from Act 
 * the two properties:
 * Character who 
 * DecimalFormat df
 * 
 * Implement write()
 * by writing on the console
 * */
@Entity
public class Speak extends Act{
	
	@ManyToOne(cascade = CascadeType.ALL)
	Person to;
	@Column(name = "speech")
	String speech;
	
	
	/**
	 * empty constructor
	 * needed by java persistence
	 * 
	 */
	public Speak(){
	}
	
	/**
	 * Constructor of a speak:
	 * 'who' say to 'to' a 'text'
	 * @param who
	 * @param to
	 * @param text
	 */
	public Speak(Person who, Person to, String text){
		this.who=who;
		this.to=to;
		this.speech=text;
	}
		
	/* (non-Javadoc)
	 * @see epic.actions.Act#write()
	 */
	public String write(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.df.format(++Counter.counter));
		sb.append(" - ");
		sb.append(this.who.getName());
		sb.append(" says");
		if(to!=null){
			sb.append(" to ");
			sb.append(this.to.getName());
		}
		sb.append(": \"");
		sb.append(speech);
		sb.append("\".");
		return sb.toString();
	}

}
