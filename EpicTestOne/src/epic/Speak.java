
public class Speak {
	String txt;
	
	public Speak(String txt) {
		this.txt = txt;		
	}
	
	public String write() {
		return "ver. " + Counter.lines++ + " - " + txt;
	}
}
