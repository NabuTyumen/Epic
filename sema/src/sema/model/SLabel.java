package sema.model;


public class SLabel {
	public SLabel(String s) {
		super();
		
		if(no(s)) this.string ="";
		this.string = s.trim().toUpperCase();
	}

	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public boolean no(String s){
		if(s==null) return true;
		if(s.equals("")) return true;
		if(s.trim().equals(" ")) return true;
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
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
		SLabel other = (SLabel) obj;
		if (string == null) {
			if (other.string != null) {
				return false;
			}
		} else if (!string.equals(other.string)) {
			return false;
		}
		return true;
	}
	
}
