package sema.mongodb;

import java.net.UnknownHostException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

import sema.model.AEntry;
import sema.model.IEntry;
import sema.model.IUnitOfWork;
import sema.model.SId;
import sema.model.SLabel;
import sema.util.SProperties;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;

/**
 * @author Bruno
 *
 */
public class MDBUnitOfWork implements IUnitOfWork {
	
	//implementation of a object Collator to sort the map (according to the Locale rules)
		private Collator collator;
		private DBCollection table;
		private Locale locale;
		//list of operation
		private List<MOperation> os ;
		private WriteConcern wc;		
		//map of the data
		private TreeMap<String,IEntry> map;
		
		
		/**
		 * Constructor of a UnitOfWork
		 * @param table
		 * @param locale
		 */
		public MDBUnitOfWork(String table, Locale locale) {
		
			//sb.append(locale.getCountry());
			this.locale=locale;
			this.table= getCollection(SProperties.getTableName(table,getLocale()));
			this.collator= Collator.getInstance(getLocale());
			this.collator.setStrength(Collator.SECONDARY);
			this.map= new TreeMap<String, IEntry>(collator);
			this.os= new ArrayList<MOperation>();
	
		}

		public MDBUnitOfWork(String table) {
			
			this.table= getCollection(SProperties.getTableName(table,getLocale()));
			this.collator= Collator.getInstance(getLocale());
			this.collator.setStrength(Collator.SECONDARY);
			this.map= new TreeMap<String, IEntry>(collator);
			this.os= new ArrayList<MOperation>();
	
		}
		

	



	private DBCollection getCollection(String name) {
		
		 try {
				MongoClient c= new MongoClient(SProperties.getHost(), SProperties.getPort() );
				DB db = c.getDB( SProperties.getDb() );
				DBCollection t = db.getCollection(name);
				if(t==null)
					t=MDBConnection.getConnection().createCollection(name,new BasicDBObject("capped", true)
			        .append("size", SProperties.getSize()) );
				
				return t;
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
				return null;
			}
	
	@Override
	public List<IEntry> get() {
		if(!os.isEmpty()){
			commit();
		}
		//if(loadData()==false) return null;
		List<IEntry> list = new ArrayList<IEntry>();
		DBCursor cursor = table.find();
		MEntry e;
		while(cursor.hasNext()){
			e=new MEntry(cursor.next(),locale);
			list.add(e);
		}
			
		return list;
	}

	private WriteResult process(MOperation o) {
		switch(o.getOperation()){
		case MOperation.UPDATE:return _update(o.getData());
		case MOperation.DELETE:return _delete(o.getData());
		default: return null;
		}
		
	}


	private WriteResult _delete(IEntry data) {
		if(data instanceof MEntry)
		return table.remove(((MEntry) data).getDBObject());
		if(data instanceof MUser)
			return table.remove(((MUser) data).getDBObject());
		return null;
	}


	private WriteResult _update(IEntry data) {
			if(data instanceof MEntry)
		   return table.save(((MEntry) data).getDBObject());
			if(data instanceof MUser)
				return table.save(((MUser) data).getDBObject());
			return null;
	}


	
	public IEntry findById(MId id) {
	    BasicDBObject query = new BasicDBObject();
	    query.put("_id", id.getOId());
	    return find(query);
	}

	private IEntry find( BasicDBObject query) {

		BasicDBObject bdo =new BasicDBObject();
		DBObject db = table.findOne(query);
		if(db!=null){
			bdo.putAll(db);
		    
		}
		return new MEntry(bdo, locale);	


	}
	
	@Override
	public IEntry find(String label) {
		BasicDBObject query = new BasicDBObject();
		query.put("label", new SLabel(label).getString());
		return find(query);
	}

	@Override
	public AEntry get(SId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean commit() {
		//if(loadData()==false) return false;
		for(MOperation o:os){
			process(o);
		}
		clear();
		return true;
	}

	@Override
	public void clear() {
		os.clear();
		map.clear();

	}

	@Override
	public List<IEntry> get(String collection) {
		// TODO Auto-generated method stub
		return null;
	}

	public Locale getLocale() {
		if(locale == null)
			locale=SProperties.getDefaultLocale();
		return locale;
	}


	public WriteConcern getWc() {
		if(wc==null){
			WriteConcern w = new WriteConcern(1,0,false);
			setWc(w);
		}
		return wc;
	}


	public void setWc(WriteConcern wc) {
		this.wc = wc;
	}


	@Override
	public void update(IEntry data) {
		os.add(new MOperation(MOperation.UPDATE, data));
		
	}


	@Override
	public void delete(IEntry data) {
		os.add(new MOperation(MOperation.DELETE, data));

	}



	@Override
	public void drop(String name) {
		try {
			MongoClient c= new MongoClient(SProperties.getHost(), SProperties.getPort() );
			DB db = c.getDB( SProperties.getDb() );
			DBCollection t = db.getCollection(name);
			if(t!=null)
				t.drop();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		}




}
