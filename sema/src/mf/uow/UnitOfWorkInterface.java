package mf.uow;

import java.util.List;

import sema.model.IEntry;
import mf.Data;

public interface UnitOfWorkInterface {
	
	 List<IEntry> get();
	 Data get(String id);
	 void display();
	 void update(Data data);
	 void delete(String id);
	 boolean commit();
	 void clear();
	
}
