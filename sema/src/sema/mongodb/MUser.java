package sema.mongodb;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import sema.model.IUser;
import sema.model.SId;
import sema.model.SLabel;

public class MUser implements IUser {
	
	
	public MUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	private MId id;
	private BasicDBObject o;
	private String firstName;
	private String secondName;
	private String famillyName;
	private String email;
	private String password;
	private Calendar date;

	@Override
	public String toJSONString() {
		JSONObject jo = new JSONObject();
		jo.put("id", getIdStr());
		jo.put("name", getName());
		jo.put("email", getEmail());
		
		return jo.toJSONString();
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getName() {
		StringBuffer sb = new StringBuffer();
		if(!no(firstName)){
			sb.append(firstName);
			sb.append(" ");
		}
		

		if(!no(secondName)){
			sb.append(secondName);	
			sb.append(" ");
		}
		
		
		if(!no(famillyName)){
			sb.append(famillyName);
			sb.append(" ");
		}
		
		return sb.toString();
	}

	private boolean no(String s) {
		if(s==null) return true;
		if("".equals(s)) return true;
		return false;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassWord() {
		return password;
	}

	public MId getId() {
		return id;
	}

	public void setId(MId id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFamillyName() {
		return famillyName;
	}

	public void setFamillyName(String famillyName) {
		this.famillyName = famillyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getIdStr() {
		return getId().getIdStr();
	}

	@Override
	public String getIdString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(SId id) {
		// TODO Auto-generated method stub
		
	}

	
	byte[] getDigest(){
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			return digest.digest(getPassword().getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DBObject getDBObject() {
		if(o==null) o = new BasicDBObject();
		o.put("label", getLabel().getString());
		o.put("firstName", getFirstName());
		o.put("secondName", getSecondName());
		o.put("famillyName", getFamillyName());
		o.put("email", getEmail());
		o.put("password", getDigest());
		o.put("tim", getDate().getTimeInMillis());
		return o;

	}

	@Override
	public SLabel getLabel() {
		
		return new SLabel(getEmail());
	}

	@Override
	public Calendar getDate() {
		if(date == null){
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			setDate(cal);
		}
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}
}
