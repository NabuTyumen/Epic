package epic.characters;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
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
			cr.add(Restrictions.eq("id", id));
			List<Person> ps = (List<Person>) cr.list();
			session.getTransaction().commit();
			if(ps.isEmpty()) return null;
			return ps.get(0);
		}finally {
			session.close();
		}
	}

	public static Person queryPerson(String name, String title, boolean mortal, char gender, List<Person> parents) {
		final Session session = getSession();
		try{
			session.beginTransaction();
			Criteria cr = session.createCriteria(Person.class);
			Criterion  c=null;
			if(name!=null){
				c=Restrictions.eq("name", name);
				cr.add(c);
			}
			if(title!=null){
				c=Restrictions.eq("title", title);
				cr.add(c);
			}

			c=Restrictions.eq("mortal", mortal);
			cr.add(c);

			if(gender!='0'){
				c=Restrictions.eq("gender", gender);
				cr.add(c);
			}
		
			List<Person> ps = (List<Person>) cr.list();
			session.getTransaction().commit();
			if(ps.isEmpty()) return null;
			return ps.get(0);
		}finally {
			session.close();
		}
	}
	public static Person saveOrUpdatePerson(Person person) {
		final Session session = getSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(person);
			session.getTransaction().commit();
			return person;
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

	public static Person saveOrUpdatePerson(int id, String field, String value) {
		Person p = queryPerson(id);
		if(p==null)
			p=new Person();

		p.set(field,value);
		return saveOrUpdatePerson(p);
	} 
}
