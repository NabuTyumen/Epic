package mf.lazzy;

import java.util.List;

import mf.Data;
import mf.uow.UnitOfWork;

public class LazzyClass {
	
	private List<Data> list;
	
	/**
	 * the getter of the property list load the data from the file "data" only if needed
	 * @return
	 */
	public List<Data> getList(String fileName){
		
		if(list == null){
			list=new UnitOfWork(fileName).get();
		}
		return list;
		
	}

	

}
