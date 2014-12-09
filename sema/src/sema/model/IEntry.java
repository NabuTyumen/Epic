package sema.model;



import java.util.Calendar;

import org.json.simple.JSONAware;

public interface IEntry extends  JSONAware {
	/**
	 * @return the id
	 */
	public abstract String getIdString();


	/**
	 * @param id the id to set
	 */
	public abstract void setId(SId id) ;
	
	String print();
	String display();
	String getContent();
	SLabel getLabel();
	Calendar getDate();

}
