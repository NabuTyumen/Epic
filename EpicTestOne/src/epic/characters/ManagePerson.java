package epic.characters;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import epic.sample.SessionFactoryUtil;

public class ManagePerson {
	
	public static Session getSession() throws HibernateException {
        return SessionFactoryUtil.getSessionFactory().openSession();
    }
	
public static List<Person> getPersons() {
	final Session session = getSession();
    session.beginTransaction();
    try{
    	Criteria cr = session.createCriteria(Person.class);
    	// To get records being human
    	//cr.add(Restrictions.eq("mortal", true));
    	@SuppressWarnings("unchecked")
		List <Person>list = (List <Person>) cr.list();
    	
    	for(Person person:list){
    		 System.out.println("Person: \"" + person.getName() +"\", " + person.getTitle() +"\", " +person.getMortalStr());
    	}
    	session.getTransaction().commit();
        return list;
    }finally {
        session.close();
    }
 
    } 

public static Person queryPerson(int id) {
	final Session session = getSession();
    try{
    session.beginTransaction();
    	Criteria cr = session.createCriteria(Person.class);
    	// To get records being human
    	Person p = (Person) cr.add(Restrictions.gt("id", id))
        .setProjection(Projections.property("id"));
    	session.getTransaction().commit();
        return p;
    }finally {
        session.close();
    }
    }
public static int saveOrUpdatePerson(Person person) {
	final Session session = getSession();
    try{
    session.beginTransaction();
	session.saveOrUpdate(person);
	session.getTransaction().commit();
	return person.getId();
    }finally {
        session.close();
    }
}

public static void delPerson(int id) {
	final Session session = getSession();
    try{
    session.beginTransaction();
	Person p = queryPerson(id);
	if(p!=null){
		session.delete(p);
		session.getTransaction().commit();
	}
    }finally {
        session.close();
    }
	
}

public static int saveOrUpdatePerson(int id, String field, String value) {
	Person p = queryPerson(id);
	if(p==null)
		p=new Person();
	
	p.set(field,value);
	return saveOrUpdatePerson(p);
} 
}
