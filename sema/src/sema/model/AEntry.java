package sema.model;

import java.util.Calendar;
import java.util.Locale;

import mf.uow.DataPrintable;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import sema.util.SProperties;

public abstract class AEntry implements JSONAware,IEntry {
	

	protected Locale locale;
	protected SLabel label;
	protected String content;
	protected String table;
	protected Calendar date;
	 

	


	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		if(locale==null)
			setLocale(SProperties.getDefaultLocale());
		return locale;
	}


	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public abstract boolean save();
	
	@SuppressWarnings("unchecked")
	@Override
	public String toJSONString() {
		JSONObject jo=new JSONObject();
		jo.put("id",getIdString());
		jo.put("lang", getLocale().getDisplayLanguage());
		jo.put("label", getLabel().getString());
		jo.put("content", getContent());
		return jo.toJSONString();
	}


	public SLabel getLabel() {
		return label;
	}


	public void setLabel(String s) {
		this.label = new SLabel(s);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AEntry other = (AEntry) obj;
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		return true;
	}


	public String getTable() {
		return table;
	}


	public void setTable(String table) {
		this.table = table;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public String getLanguage() {
		return getLocale().getLanguage();
	}
	
	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append(getIdString());
		sb.append(" | ");
		sb.append(getLanguage());
		sb.append(" | ");
		sb.append(getLabel().getString());
		sb.append(" : ");
		sb.append(getContent());
		return sb.toString();
	}

	@Override
	public String display() {
		return print();
	}
	
	

}
