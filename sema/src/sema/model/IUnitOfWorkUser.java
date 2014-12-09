package sema.model;

import java.util.List;


public interface IUnitOfWorkUser extends IUnitOfWork {
	List<IEntry> get();
	void drop();
	IUser get(SId id);
	IEntry find(String label);
	void display();
	void update(IEntry data);
	void delete(IEntry data);
	boolean commit();
	void clear();

}
