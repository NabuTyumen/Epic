package sema.mongodb;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List; 
import java.util.Locale;
import java.util.Map.Entry;
import java.util.TreeMap;

import mf.Data;
import mf.uow.DataPrintable;
import junit.framework.TestCase;
import sema.model.AEntry;
import sema.model.IEntry;
import sema.util.SProperties;
import sema.util.TextUtil;
import sema.util.UnitOfWork;

public class TestMUnitOfWork extends TestCase {
	private static final String filePath = SProperties.getString("datatest.filePath");
	private static final String fileName = filePath+SProperties.getString("datatest.fileName");
	private static final String tableName=SProperties.getString("datatest.tableName");
	private static final int nbid=SProperties.getInt("datatest.nbid");
	private static final int nbval=SProperties.getInt("datatest.nbval");;
	//implementation of a object Collator to sort the map (according to the Locale rules)
	private static HashMap<String, Collator> collators = new HashMap<String, Collator>();
	//Maps of the entry by language
	private static HashMap<String, TreeMap<String,IEntry>> maps = new HashMap<String, TreeMap<String,IEntry>>() ;
	//Maps of the unit of works to process update and delete in the collections test on MongoDB
	private static HashMap<String, MDBUnitOfWork> uow = new HashMap<String, MDBUnitOfWork>() ;
	//unit of work to load the data from a file
	private UnitOfWork u  ;
	private List<IEntry> alldata ;
	private MEntry dummy;
	private List<MEntry>dummylist  ;
	private List<Data>datalist;

	//Construct and store by language a Collator taking as parameter a Locale build by invocation of the Factory method Locale.forLanguageTag
	private static Collator getCollator(String language) {
		if(collators.get(language)==null){
			Collator collator= Collator.getInstance( SProperties.getLocale(language));
			collator.setStrength(Collator.SECONDARY);
			collators.put(language, collator);
		}

		return collators.get(language);
	}

	private static MDBUnitOfWork getUow(String language){
		Locale locale = SProperties.getLocale(language);
		String name =SProperties.getTableName(tableName, locale);
		if(uow.get(name) == null){
			uow.put(name, new MDBUnitOfWork(tableName, locale));
		}
		return uow.get(name);
	}

	private static MEntry getDummyEntry() {
		MEntry e = new MEntry(SProperties.getDefaultLocale());
		String content = "Lorsque avec ses enfants vêtus de peaux de bêtes,";
		Calendar cal = new GregorianCalendar(); cal.setTime(new Date());
		e.setLabel("labtest2");
		e.setContent(content);
		e.setDate(cal);
		return e;
	}

	public void testUpdateDeleteListUser(){
		String email = "gilgamesh@uruk.com";
		String password = ".3enk1d.";
		Locale locale = SProperties.getDefaultLocale();
		IEntry e = new MUser(email, password);
		
		MDBUnitOfWork u_=new MDBUnitOfWork("users", locale);
		u_.update(e);
		u_.commit();
		u_.find(e.getLabel().getString());
		
		
		
	}

	public void testUpdateDeleteList() {


		long beg = new Date().getTime();

		MDBUnitOfWork u_=new MDBUnitOfWork("test", SProperties.getLocale("fr"));
		u_.drop("test.fr");
		u_=new MDBUnitOfWork("test", SProperties.getLocale("en"));
		u_.drop("test.en");
		u_=new MDBUnitOfWork("test", SProperties.getLocale("ru"));
		u_.drop("test.ru");
		u_=new MDBUnitOfWork("test", SProperties.getLocale("es"));
		u_.drop("test.es");
		//drop collections
		//for(Entry<String, MDBUnitOfWork>u:uow.entrySet()){
		//	u.getValue().drop(u.getKey());	
		//}

		//create a collection of entry by language
		//update in the database
		for(MEntry e:getDummylist()){
			getUow(e.getLanguage()).update(e);
		}
		//commit of the unit of work by language
		for(Entry<String, MDBUnitOfWork>u:uow.entrySet()){
			u.getValue().commit();	
		}
		//display time
		long end = new Date().getTime();
		long time = end - beg;
		System.out.println("update       : t0+" + time);


		//check equality between Data and MEntry
		int n=0;
		for(Data d:getDatalist()){
			dummy = (MEntry) getUow(d.getLanguage()).find(d.getId());
			assertEquals(dummy.getLabel().getString(), d.getId().toUpperCase());
			//fail("fail equal label : " + dummy.display() + " VS. " + d.display());
			assertEquals("isEquals content : " +n + "e value "+ dummy.display() + " VS. " + d.display(),dummy.getContent(), d.getContent());
			//fail("fail equal content : " + dummy.display() + " VS. " + d.display());
			n++;
		}
		assertEquals(n,nbid);

		end = new Date().getTime();
		time = end - beg;
		System.out.println("check update : t0+" + time);


		//list and count collections
		TreeMap<String,IEntry> map;
		List<IEntry> list;
		for(Entry<String, MDBUnitOfWork>uo:uow.entrySet()){
			map = new TreeMap<String, IEntry>();
			list = uo.getValue().get();
			for(IEntry e:list){
				map.put(e.getLabel().getString(), e);
			}
			System.out.println(uo.getKey() +" : "+ list.size());	
			u = new UnitOfWork(filePath+uo.getKey());
			u.printFile(map);
			
		}
		//print collection
		

		for(MEntry e:dummylist){
			getUow(e.getLanguage()).delete(e);
		}
		for(Entry<String, MDBUnitOfWork>u:uow.entrySet()){
			u.getValue().commit();	
		}
		end = new Date().getTime();
		time = end - beg;
		System.out.println("del          : t0+" + time);
		for(Data d:getDatalist()){
			dummy = (MEntry) getUow(d.getLanguage()).find(d.getId());
			assertEquals(dummy.getIdString(),"");
		}

		end = new Date().getTime();
		time = end - beg;
		System.out.println("check del    : t0+" + time);

		//drop collections
		for(Entry<String, MDBUnitOfWork>u:uow.entrySet()){
			System.out.println(u.getKey() +" : "+ u.getValue().get().size());	

		}
	}

	public void testUpdateDelete()  {
		MDBUnitOfWork uow = getUow("en");
		dummy = getDummyEntry();
		uow.update(dummy);
		uow.commit();

		dummy = (MEntry) uow.find("labtest2");
		assertEquals(dummy.getLabel().getString(), "LABTEST2");
		uow.delete(dummy);
		uow.commit();
		dummy = (MEntry) uow.findById(dummy.getId());
		assertEquals(dummy.getIdString(),"");
	}

	public List<IEntry> getAlldata() {
		if(alldata==null){
			List<IEntry> all = getU().get();
			setAlldata(all);
		}
		return alldata;
	}





	public void setAlldata(List<IEntry> all) {
		this.alldata = all;
	}





	public UnitOfWork getU() {
		if(u==null){
			setU(new UnitOfWork(fileName));
		}
		return u;
	}





	public void setU(UnitOfWork u) {
		this.u = u;
	}





	public List<MEntry> getDummylist() {
		if(dummylist==null){
			List<MEntry> es = new ArrayList<MEntry>();
			MEntry e;
			Calendar cal;

			for(Data d:getDatalist()){
				e=new MEntry(SProperties.getLocale(d.getLanguage()));
				e.setLabel(new String(d.getId()));
				e.setContent(new String(d.getContent()));
				cal = new GregorianCalendar();
				cal.setTime(new Date());
				e.setDate(cal);
				es.add(e);
			}
			setDummylist(es);
		}
		return dummylist;
	}





	public void setDummylist(List<MEntry> dummylist) {
		this.dummylist = dummylist;
	}





	/**
	 * create a random list of label - content 
	 * @return
	 */
	public List<Data> getDatalist() {
		if(datalist==null){
			List<Data> ds = new ArrayList<Data>();
			List<IEntry> all = getAlldata();

			Data d;


			int max = all.size()-1;
			StringBuffer sb ;
			//creation of a list of nbid integer
			List<Integer> listi,list0 = TextUtil.randListInt(0, max, nbid); 
			
			//for each new entry create a random text
			for(Integer i:list0){
				sb = new StringBuffer();
				listi = TextUtil.randListInt(0, max, TextUtil.randInt(0, nbval));
				for(Integer j:listi){
					sb.append(all.get(j).getLabel().getString());
					sb.append(" ");
				}

				MEntry ie = (MEntry) all.get(i);
				d=new Data(ie.getLabel().getString(), sb.toString(), ie.getLocale().getLanguage());
				ds.add(d);

			}
			setDatalist(ds);
		}
		return datalist;
	}





	public void setDatalist(List<Data> datalist) {
		this.datalist = datalist;
	}

	/**
	 * @return the maps
	 */
	public static TreeMap<String,IEntry> getMap(String langage) {
		if(!maps.containsKey(langage)){
			maps.put(langage, new TreeMap<String, IEntry>(getCollator(langage)));
		}
		return maps.get(langage);
	}




}
