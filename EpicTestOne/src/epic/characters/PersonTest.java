package epic.characters;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PersonTest extends TestCase {
	
	private Person person;
	
	public PersonTest(String name) {
	    super(name);
	  }

	  protected void setUp() throws Exception {
	    super.setUp();
	    person = new Person(0, "nom1","title1", false, 'M', null);
	  }

	  protected void tearDown() throws Exception {
	    super.tearDown();
	    person = null;
	  }
	  
	  public void testPersonne() {
		    assertNotNull("Person created", person);
		  }

		  public void testGetName() {
		    assertEquals("Is this name correct", "nom1", person.getName());
		  }

		  public void testSetName() {
		    person.setName("nom2");
		    assertEquals("Is this name correct", "nom1", person.getName());
		  }

		  public void testGetTitle() {
		    assertEquals("Is this title correct", "title1", person.getTitle());
		  }

		  public void testSetTitle() {
		    person.setTitle("title1");
		    assertEquals("Is this title correct", "title1", person.getTitle());
		  }
		  
		  public static Test suite() {
			    TestSetup setup = new TestSetup(new TestSuite(PersonTest.class)) {
			      protected void setUp() throws Exception {
			        // code execute une seule fois avant l'exécution des cas de tests
			        System.out
			            .println("Appel de la methode setUp() de la classe de tests");
			      }

			      protected void tearDown() throws Exception {
			        // code execute une seule fois après l'exécution de tous les cas de tests
			        System.out
			            .println("Appel de la methode tearDown() de la classe de tests");
			      }
			    };
			    return setup;
			  }
			  
			  public static void main(String[] args) {
			      junit.textui.TestRunner.run(suite());
			  }
		  
}
