package mf;

public class Data {
	

	private String id;
	private String value;
	
	/**
	 * constructor
	 * @param id
	 * @param value
	 */
	public Data(String id, String value) {
		super();
		this.id = id;
		this.value = value;
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
		sb.append(value);
		return sb.toString();
	}
	
	public String print(){
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append(";");
		sb.append(value);
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
}
