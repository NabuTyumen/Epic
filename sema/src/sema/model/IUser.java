package sema.model;

import mf.uow.DataPrintable;

import org.json.simple.JSONAware;

public interface IUser extends IEntry,JSONAware,DataPrintable{
	String getIdStr();
	String getName();
	String getEmail();
	String getPassWord();
	
	

}
