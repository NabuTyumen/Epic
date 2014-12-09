package mf;

import mf.uow.DataPrintable;


public class Data implements DataPrintable{
	

	private String id;
	private String content;
	private String language;
	
	/**
	 * constructor
	 * @param id
	 * @param value
	 */
	public Data(String id, String value, String lang) {
		super();
		this.id = id;
		this.content = value;
		this.language=lang;
	}
	
	public Data(String line) {
		String[] array = line.split(";");
		if(array!=null && array.length==3){
			this.id = array[0];
			this.content = array[1];	
			this.language = array[2];	
		}
		
	}
	/**
	 * method to display the content of the object
	 * @return
	 */
	public String display(){
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(id);
		sb.append(", value: ");
		sb.append(content);
		return sb.toString();
	}
	
	public String print(){
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append(";");
		sb.append(content);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Data other = (Data) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}



	public String getId() {
		if(id==null) return "";
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String value) {
		this.content = value;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
}
