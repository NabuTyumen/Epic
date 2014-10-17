package epic;

public class Speak {
	
	String text;
	
	public Speak(String txt) {
		text = txt;
	}

	public  String writeString ()
	{
		String s = "Ver."+Counter.lines++ + text;
		return s;
	}

}
