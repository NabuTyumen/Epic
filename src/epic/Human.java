

public class Human {
	private String name;
	private Human parent_1;
	private Human parent_2;
	private String gender;
	private String mortal;
	public String getName() {
		return name;
	}
	public Human getParent_1() {
		return parent_1;
	}
	public Human getParent_2() {
		return parent_2;
	}
	public String getGender() {
		return gender;
	}
	public String getMortal() {
		return mortal;
	}
	void setInfo(String i1, String i2){
		this.gender = i1;
		this.mortal = i2;
	}
	Human(String n, String i1, String i2, Human p1) {
		this.name = n;
		this.parent_1 = p1;
		setInfo(i1, i2);
	}
	Human(String n, String i1, String i2, Human p1, Human p2) {
		this.name = n;
		this.parent_1 = p1;
		this.parent_2 = p2;
		setInfo(i1, i2);
	}
	Human(String n, String i1, String i2) {
		this.name = n;
		setInfo(i1, i2);
	}
	
	String printer(){
		String s = getName();
		if (getMortal() != null)
			s = s + ", " + getMortal();

		if (getGender() != null &&
				(getParent_1() != null || getParent_2() != null))
		{
			s = s  + " " + getGender() + " of ";
			if (getParent_1() != null)
				s = s + getParent_1().printer();
			if (getParent_2() != null)
			{
				if (getParent_1() != null)
					s = s + " and ";
				s = s + getParent_2().printer();
			}
		}
		return s;
	}
}
