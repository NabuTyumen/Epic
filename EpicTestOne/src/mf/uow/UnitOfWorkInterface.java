package mf.uow;

import mf.Data;

public interface UnitOfWorkInterface {
	

	public void insertData(Data data);
	public void updateData(Data data);
	public void deleteData(Data data);
	public void commit();
	public void clear();
}
