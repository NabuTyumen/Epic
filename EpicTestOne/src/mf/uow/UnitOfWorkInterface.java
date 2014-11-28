package mf.uow;

import java.util.List;

import mf.Data;

public interface UnitOfWorkInterface {
	
	 List<Data> get();
	 Data get(String id);
	 void display();
	 void update(Data data);
	 void delete(String id);
	 boolean commit();
	 void clear();
	
}
