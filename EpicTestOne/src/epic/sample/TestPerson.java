package epic.sample;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import epic.actions.Speak;
import epic.characters.Person;

public class TestPerson {
	public static void main(String[] args) {
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();
         
        createPerson(session);
        
        createSpeaks(session,queryPersons(session));
        
        session.getTransaction().commit();
    }
 
    private static List<Person> queryPersons(Session session) {
    	
    	Criteria cr = session.createCriteria(Person.class);
    	// To get records being human
    	cr.add(Restrictions.eq("mortal", true));
    	@SuppressWarnings("unchecked")
		List <Person>list = (List <Person>) cr.list();
    	
    	for(Person person:list){
    		 System.out.println("Person: \"" + person.getName() +"\", " + person.getTitle() +"\", " +person.getMortalStr());
    	}
       
        return list;
 
    }
    
    public static void createSpeaks(Session session, List<Person> ps){
    	Person to=null;
    	for(Person p:ps){
    		Speak s = p.introduce(to);
    		s.write();
    		to=p;
            session.save(s);
    	}
    	
    }
    public static void createPerson(Session session) {
               
        Person an = new Person();
        an.setName("An");
        an.setTitle("God of Heaven");
        an.setMortal(false);
        an.setGender('M');
        
        Person enlil = new Person();
        enlil.setName("Enlil");
        enlil.setTitle("Lord of Storm");       
        enlil.setMortal(false);
        enlil.setGender('M');
        
        Person ninsun  = new Person();
        ninsun.setName("Ninsun");
        ninsun.setTitle("Lady Wild Cow");       
        ninsun.setMortal(false);
        ninsun.setGender('F');
        
        Person lugal  = new Person();
        lugal.setName("Lugalbanda");
        lugal.setTitle("King of Uruk");       
        lugal.setMortal(true);
        lugal.setGender('M');
       
        Person siduri  = new Person();
        siduri.setName("Siduri");
        siduri.setTitle("Alewife");       
        siduri.setMortal(true);
        siduri.setGender('F');
        
        Person g = new Person();
        g.setName("Gilgamesh");
        g.setTitle("King of Uruk");
        g.setMortal(true);
        g.setGender('M');

        
       Person[] ps = {an};      
        enlil.setParents(ps);
        ninsun.setParents(ps);
      
        
        Person[] pg = {lugal,ninsun};      
        g.setParents(pg);
        
        session.save(enlil);
        session.save(g);
        session.save(siduri);
        
    }
}
