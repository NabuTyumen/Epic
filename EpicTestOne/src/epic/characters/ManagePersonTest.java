package epic.characters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ManagePersonTest {
	Person dad = new Person( 0, "Daddy", "test1", true, 'M',null);
	Person mom = new Person( 0, "Mama", "test2", true, 'F',null);
	List<Person> parents = getParents();

	Person u = new Person(0, "Nabu", "test3", true, 'M',parents);
	Person a = new Person(0, "Naba", "test4", true, 'F',parents);
	

	private List<Person> getParents() {
		List<Person> ps = new ArrayList<Person>();
		ps.add(dad);
		ps.add(mom);
		return ps;
	}


	@Test
	public void testSaveOrUpdatePersonPerson() {
		u= ManagePerson.saveOrUpdatePerson(u);
		Person u_=ManagePerson.queryPerson(u.getId());
		assertEquals("testSaveOrUpdatePersonPerson Nabu fail",u, u_);
		assertTrue("testSaveOrUpdatePersonPerson Nabu fail parent",u_.haveThisParents(u.getParents()));
		ManagePerson.delPerson(u.getId());
	}

	@Test
	public void testDelPerson() {
		a= ManagePerson.saveOrUpdatePerson(a);
		Person a_=ManagePerson.queryPerson(a.getId());
		assertEquals("testDelPerson Naba fail on insert",a, a_);
		ManagePerson.delPerson(a.getId());
		assertNull("testDelPerson Naba fail on delete",ManagePerson.queryPerson(a.getId()));
	}

	@Test
	public void testSaveOrUpdatePersonIntStringString() {
		u= ManagePerson.saveOrUpdatePerson(u);
		Person u_=ManagePerson.queryPerson(u.getId());
		assertEquals("testSaveOrUpdatePersonIntStringString Nabu fail on insert",u, u_);

		ManagePerson.saveOrUpdatePerson(u.getId(), "title", "citizen3");
		u_=ManagePerson.queryPerson(u.getId());
		assertEquals("testSaveOrUpdatePersonIntStringString Nabu fail on update","citizen3", u_.getTitle());
		ManagePerson.delPerson(u.getId());
	}

}
