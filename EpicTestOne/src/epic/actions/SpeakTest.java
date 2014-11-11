package epic.actions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import epic.characters.Person;

public class SpeakTest {
	protected Speak speak;
	protected Person who;
	protected Person to;
	protected Person her;
	@Before
	public void setUp() throws Exception {
		to = new Person(1, "to", "listener", true, 'M', null);
		her = new Person(1, "her", "mother", true, 'F', null);
		who = new Person(2, "who", "speaker", true, 'M', null);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWrite() {
		
		ArrayList<Person> parents = new ArrayList<Person>();
		parents.add(to);
		parents.add(her);
		who.setParents(parents);
		to.setParents(parents);
		her.setParents(parents);
		
		speak = who.introduce(to);
		System.out.println(speak.write());
		Counter.counter=0;
		assertEquals("Test write","01 - who says to to: \"I am who, mortal son of to, mortal son of to and her and her, mortal daughter of to and her\".",speak.write());
	
	}


}
