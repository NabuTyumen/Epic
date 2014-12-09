package sema.model;

import java.util.List;


public interface IUnitOfWork {

	List<IEntry> get();
	List<IEntry> get(String collection);
	void drop(String collection);
	IEntry get(SId id);
	IEntry find(String label);
	void display();
	void update(IEntry data);
	void delete(IEntry data);
	boolean commit();
	void clear();
	
	
	

}
