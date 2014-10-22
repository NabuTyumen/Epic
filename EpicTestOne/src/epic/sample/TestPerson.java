package epic.sample;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import epic.characters.Person;

public class TestPerson {
	public static void main(String[] args) {
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
 
        createPerson(session);
 
        queryPerson(session);
 
    }
 
    private static void queryPerson(Session session) {
        Query query = session.createQuery("from Person");                 
        List <Person>list = query.list();
        java.util.Iterator<Person> iter = list.iterator();
        while (iter.hasNext()) {
 
            Person person = iter.next();
            System.out.println("Person: \"" + person.getName() +"\", " + person.getTitle() +"\", " +person.getMortalStr());
 
        }
 
        session.getTransaction().commit();
 
    }
 
    public static void createPerson(Session session) {
        Person person = new Person();
 
        person.setName("BarakO");
        person.setTitle("POTUS");       
        person.setMortal(true);
        person.setGender('M');
 
        session.save(person);
    }
}
