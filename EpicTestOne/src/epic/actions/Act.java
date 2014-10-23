package epic.actions;

import java.text.DecimalFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import epic.characters.Person;

@Entity
@Table(name = "act")
public abstract class Act {
	@Id @GeneratedValue
	@Column(name = "id")
	protected int id;

	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Person who;
	
	@Transient 
	protected final DecimalFormat df = new DecimalFormat("00");
	
	public abstract String write();

}
