package sema.mongodb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.bson.BasicBSONObject;

import sema.model.AEntry;
import sema.model.SId;
import sema.model.SLabel;
import sema.util.SProperties;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class MEntry extends AEntry {
	MId id;
	BasicDBObject o;
	
	public MEntry(String label,String content,Locale locale){
		this.label=new SLabel(label);
		this.content=content;
		this.locale=locale;
	}

	public MEntry(DBObject dbo, Locale locale) {
			
		if(dbo!=null){
			BasicDBObject bdo = new BasicDBObject();
			bdo.putAll(dbo);
			o = bdo;
			
			this.id= new MId(o.getObjectId("_id"));
			
			if(dbo.containsField("label"))
				this.label = new SLabel( o.getString("label"));
			
			if(dbo.containsField("content"))
				this.content = o.getString("content");
			
			Calendar cal = new GregorianCalendar();
			if(o.containsField("tim")){
				cal.setTimeInMillis(o.getLong("tim"));				
			}else{
				cal.setTime(new Date());
			}

			this.date=cal;
		}
		this.locale=locale;	
		
	}
	
	public MEntry(Locale locale) {
		this.locale=locale;
	}


	public MEntry(String line) {
		if(line != null){
			String[] array = line.split(";");
			if(array!=null && array.length==3){
		
				this.label = new SLabel( array[1]);
				
				this.locale = SProperties.getLocale(array[2]);	
			}	
		}
		
	}

	public DBObject getDBObject(){
		o = getNewDBObject();
		if(getId()!=null)
		o.put("_id", getId().getOId());
		return o;
	}
	
	public MId getId() {
		return id;
	}

	public BasicDBObject getNewDBObject() {
		if(o==null) o = new BasicDBObject();
		o.put("label", getLabel().getString());
		o.put("content", getContent());
		o.put("tim", getDate().getTimeInMillis());
		return o;
	}
	@Override
	public String getIdString() {
		if(getId()!=null && getId().getOId()!=null)
		return getId().getOId().toString();
		return "";
	}
	

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setId(SId id) {
		// TODO Auto-generated method stub
		
	}

	

	


}
